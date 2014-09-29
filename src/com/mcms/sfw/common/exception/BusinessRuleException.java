package com.mcms.sfw.common.exception;

public class BusinessRuleException  extends  RuntimeException
{

	private static final long m = 1L;

    public String info = "";
	public BusinessRuleException(){
    }

	public BusinessRuleException(String msg,String info){
		super(msg);
        this.info=info;
	}

    @Override
    public String toString(){
        return info;
    }
}
