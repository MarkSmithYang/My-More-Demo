package com.ddb.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.ddb.demo.common.DataInfo;
import com.ddb.demo.model.CtiyAndPerson;
import com.ddb.demo.model.DemoModel;
import com.ddb.demo.model.Holiday;
import com.ddb.demo.service.DemoService;
import com.ddb.demo.utils.ExcelExportUtils;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("a")
	public DataInfo<Page<DemoModel>> name(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "age", required = false) String age, HttpServletResponse response) {
		// DataInfo<Page<DemoModel>> dataInfo = new DataInfo<Page<DemoModel>>();

		// 这里没有做参数的校验，是因为后面在组合查询时，会做判断和校验
		Page<DemoModel> pages = demoService.findDemo(username, age);

		if (pages == null) {
			System.err.println("pages居然可以为空?");
		}
		System.err.println("pages不会为空啦");

		// if (pages!=null) {page不可能为空
		return DataInfo.success(pages);
		// }
		// dataInfo.setData(pages);//当然了,对于参数的校验,可以使用断言,因为,参数不对,需要提示用户,但提示需要是友好的,不带语气词的
		// return dataInfo;

		// }else {
		// dataInfo.setStatus(400);
		// dataInfo.setMessage("查询出错");//不能写类似于查询出错的这种信息,只去提示用户输入参数错误的信息,查询不到信息,不能提示用户,只能返回空值i,空数组或空集合
		// return dataInfo;

		// }
	}

	@RequestMapping("me")
	public DataInfo<List<CtiyAndPerson>> myTest() {
		List<CtiyAndPerson> list = demoService.query();
		System.err.println(list.toArray().toString());
		return DataInfo.success(list);
	}

	@RequestMapping("aa")
	public DataInfo<Integer> ExcelExport(HttpServletResponse response) {

		ExcelExportUtils pee = new ExcelExportUtils("E:/test.xls", "sheet2");

		DataInfo<Integer> dataInfo = new DataInfo<Integer>();
		List<DemoModel> list = demoService.findDemoModell();
		if (list != null && list.size() > 0) {
			// 调用
			String titleColumn[] = { "id", "username", "age", "address" };
			String titleName[] = { "编号", "姓名", "年龄", "地址" };
			int titleSize[] = { 13, 13, 13, 13 }; // 列宽
			pee.setAddress("A:D"); // 自动筛选

			pee.wirteExcel(titleColumn, titleName, titleSize, list);
			System.err.println("成功啦");
		}
		return dataInfo;
	}

	// @ApiOperation("判断日期是否是节假日")
	// @ApiImplicitParams({@ApiImplicitParam(name="date",value="日期",paramType="query",dataType="string")})
	// @GetMapping("checkHoliday")
	// public DataInfo<String> checkHoliday(){
	// return null;
	//
	// }

	// 工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2

	// http://api.goseek.cn/Tools/holiday?date=20170528
	@GetMapping("checkHoliday")
	public String checkHoliday() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.valueOf(new SimpleDateFormat("yyyy").format(calendar.getTime())));
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			calendar.set(Calendar.DAY_OF_YEAR, i);
			System.out.println();

			String url = "http://api.goseek.cn/Tools/holiday?date="
					+ new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
			JSONObject forObject = restTemplate.getForObject(url, JSONObject.class);

			if ("0".equals(forObject.getString("data"))) {
				Holiday holiday = new Holiday(String.valueOf(i), forObject.getString("data"), "工作日");
			} else if ("1".equals(forObject.getString("data"))) {
				Holiday holiday = new Holiday(String.valueOf(i), forObject.getString("data"), "休息日");
			} else if ("2".equals(forObject.getString("data"))) {
				Holiday holiday = new Holiday(String.valueOf(i), forObject.getString("data"), "节假日");
			}
			return null;
		}
		return null;
	}

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.valueOf(new SimpleDateFormat("yyyy").format(calendar.getTime())));
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			calendar.set(Calendar.DAY_OF_YEAR, i);
			System.out.println(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
		}
	}

	// int aa = 0;
	// System.err.println("aaaaa: "+aa);
	//
	// List<Person> list = new ArrayList<>();
	// List<Person> list1 = new ArrayList<>();
	// list.add(new Person("1", "美国", "华尔街"));
	// list1.add(new Person("1", "美国", "华尔街"));
	// list1.add(new Person("2", "美国", "华尔街"));

	// Set<Person> set = new HashSet<>();

	// JSONObject jsonObject = new JSONObject();
	// jsonObject.put("list", list);
	//
	// List<Person> object = (List<Person>) jsonObject.get("list");
	// System.err.println(object);

	// for (Person person : list1) {
	// set.add(person);
	// }
	// for (Person person : list) {
	// set.add(person);
	// }

	// Set<Person> set = new HashSet<>(object);
	//
	// List<Person> lll = new ArrayList<>(set);
	// lll.clear();
	//
	// System.err.println(lll);
	// System.err.println("-------------------");
	// System.err.println(set.size());
	// System.err.println(set);
	//
	// if (set.size()>0) {
	// aa = aa+10;
	// }

	// }

}
