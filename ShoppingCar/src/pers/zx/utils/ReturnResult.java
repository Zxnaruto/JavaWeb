package pers.zx.utils;

import pers.zx.utils.Constants;
import pers.zx.utils.ReturnResult;

/**
 * @author zx
 * ������ع�����
 *
 */
public class ReturnResult {

	 private int status;
	 private Object data;
	 private String message;
	 
	 
	    public ReturnResult() {
		// TODO Auto-generated constructor stub
	}


		public int getStatus() {
			return status;
		}


		public void setStatus(int status) {
			this.status = status;
		}


		public Object getData() {
			return data;
		}


		public void setData(Object data) {
			this.data = data;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		/**
	     * ���سɹ�״̬
	     * @param obj
	     */
	    public ReturnResult returnSuccess(Object obj){
	        this.status=Constants.ReturnResult.SUCCESS;
	        this.data=obj;
	        return this;
	    }
	    
	    /**
	     * ����ʧ��״̬
	     * @param message
	     */
	    public ReturnResult returnFail(String message){
	        this.status=Constants.ReturnResult.FAIL;
	        this.message=message;
	        return this;
	    }
}
