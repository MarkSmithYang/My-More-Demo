package com.ddb.demo.lambda.demo;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("Excel导入数据的封装实体")
@Entity
@Table
public class Student implements Serializable, IExcelModel, IExcelDataModel, IExcelVerifyHandler<T> {
	private static final long serialVersionUID = 2209180061463421492L;

	@Id
	@ApiModelProperty("id")
	@Column(length = 128)
	private String id;

	@NotBlank(message = "姓名不能为空") // 这个可以根据具体需求添加校验
	@Excel(name = "姓名", orderNum = "0", isImportField = "name", mergeVertical = true)
	@Pattern(regexp = "^([\\u4e00-\\u9fa5]){2,5}$", message = "姓名中文只能2~5字") // 根据需求调整,这个正则才是对的,之前的那个是错的
	@ApiModelProperty("姓名")
	@Column(length = 128)
	private String name;

	@Excel(name = "性别", orderNum = "1", isImportField = "sex", mergeVertical = true)
	@NotBlank(message = "性别不能为空") // 这个可以根据具体需求添加校验
	@Pattern(regexp = "[男,女]{1}", message = "性别只能是男或女") // 根据需求调整(男生,女生(0,1)等)
	@ApiModelProperty("性别")
	@Column(length = 128)
	private String sex;

	@Excel(name = "年龄", orderNum = "2", isImportField = "age", mergeVertical = true)
	@Min(value = 0, message = "年龄不能小于0")
	@Max(value = 160, message = "年龄不能大于160")
	@ApiModelProperty("年龄")
	@Column(length = 128)
	private Integer age;

	@Excel(name = "班级", orderNum = "3", isImportField = "classGrade", mergeVertical = true)
	@NotBlank(message = "班级不能为空") // 这个可以根据具体需求添加校验
	@Length(min = 4, max = 10, message = "班级字数不能小于4个字,也不能多于10字") // 根据需求调整
	@ApiModelProperty("班级")
	@Column(length = 128)
	private String classGrade;

	@Excel(name = "出生日期", orderNum = "4", isImportField = "birthday", mergeVertical = true, importFormat = "yyyy-MM-dd")
	@ApiModelProperty("出生日期")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 128)
	private Date birthday;

	// pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp

	@Excel(name = "错误信息", orderNum = "5", isImportField = "errorMsg", mergeVertical = true)
	@Transient
	@ApiModelProperty("错误信息")
	private String errorMsg;

	// @Excel(name = "导入数据所在行", orderNum = "6", isImportField = "rowNum",
	// mergeVertical = true)
	@Transient
	@ApiModelProperty("导入数据所在行") // 一般来说,这个行号都是用来提示用户哪行有错误的,所以这个可以做个消息提示,而不是像错误信息那样需要对应具体的行号
	private Integer rowNum = 0;// 实测这个初始化的0并会不改变数据行的行号,尝试了-1和1数据行都是从2开始的,这个只能其实也没有什么必要了,这个只有在特定的需要通过行号指定
	//错误信息的时候才有用,我们这里只需要返回导入错误/失败的数据就可以了,没有问题的就根本不需要返回,那样还影响用户排序错误,当然了有特殊需要的就需要这个行号了,
	//不然就没有必要,如果数据行是从2开始的,就直接减去1就行了

	// 88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
	public Student() {
		super();
		this.id = UUID.randomUUID().toString().replaceAll("-", "");
	}
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", classGrade=" + classGrade
				+ ", birthday=" + birthday + ", errorMsg=" + errorMsg + ", rowNum=" + rowNum + "]";
	}

	// 88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888

	// -----------------------------------------------------------------------------------------------------------------------------------
	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public int getRowNum() {
		return rowNum;
	}

	@Override
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
		verifyHandler(null);
	}

	@Override // 注意这个方法需要调用才会生效,这个主要是用来自定义校验的,一般也用不着,
	// 就是方法的参数很奇怪,好像用不不着,之前是用另一个类来继承这个实体类的,我觉得没有必要,
	// 也不好用,所以直接在实体做了,其实这个就直接使用属性值进行校验就行了,用一个每次都会调用
	// 的属性的set方法来额外的调用这个方法,让他生效就行了我就是用setRowNum这个方法的------->没有自定义校验的需要,就不用实现IExcelVerifyHandler<T>接口了
	public ExcelVerifyHandlerResult verifyHandler(T obj) {
		// System.err.println("小娘子,我来啦");
		// if (obj != null) {
		// System.err.println(obj.toString());
		// }
		// boolean matches = this.getName().matches("^([\\u4e00-\\u9fa5]){2,5}$");//
		// ^([\u4e00-\u9fa5]){2,7}$
		// if (!matches) {
		// this.errorMsg = "姓名中文只能2~5字";
		// }
		return null;
	}

	public Student(String name, String sex, Integer age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------
}
