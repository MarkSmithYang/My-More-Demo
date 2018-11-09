package com.ddb.demo.common;


/**
 * @author Administrator
 * 之前的这个datainfo用起来不是很方便,这里通过添加两个静态方法来改善它
 * @param <T>
 */
public class DataInfo<T> extends BaseInfo{

	private T data;

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public static <T> DataInfo<T> success(T t) {
		DataInfo<T> info = new DataInfo<>();
		info.setStatus(SUCCESSS_STATUS);
		info.setMessage(SUCCESSS_MESSAGES);
		info.setData(t);
		return info;
	}
	
	public static <T> DataInfo<T> error(String message) {
		DataInfo<T> info = new DataInfo<>();
		//info.setStatus(400);
		info.setStatus(FAIL_STATUS);
		info.setMessage(message);
		return info;
	}
	
	/**
	 * 事实证明需要添加<T>来声明此方法是泛型方法,不然就会报错
	 * @param t
	 * @return
	 */
	public static <T> T getName(T t) {
		return t;
	}
	
}
