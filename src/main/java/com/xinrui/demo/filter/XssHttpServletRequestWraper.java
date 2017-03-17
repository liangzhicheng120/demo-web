package com.xinrui.demo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;



/**
 * 
 * @ClassName: XssHttpServletRequestWraper
 * @Description: 使用装饰者模式,HttpServletRequestWraper是HttpServletRequest的装饰者
 * @author 梁志成
 * @date 2016年3月17日 下午10:48:50
 *
 */
public class XssHttpServletRequestWraper extends HttpServletRequestWrapper
{
	
	
	public XssHttpServletRequestWraper ( HttpServletRequest request )
	{
	
		super ( request );
		
	}
	
	@Override
	public String getParameter ( String name )
	{
	
		return clearXss ( super.getParameter ( name ) );
	}
	
	@Override
	public String getHeader ( String name )
	{
	
		return clearXss ( super.getHeader ( name ) );
	}
	
	/**
	 * 处理路径中的转义字符
	 */
	@Override
	public String [ ] getParameterValues ( String name )
	{
		System.out.println(name);
		String [ ] values = super.getParameterValues ( name );
		String [ ] newValues = new String [ values.length ];
		for ( int i = 0 ; i < values.length ; i ++ )
		{
			newValues [ i ] = clearXss ( values [ i ] );
		}
		return newValues;
	}
	
	/**
	 * 清除路径中的转义字符
	 */
	public String clearXss ( String value )
	{
	
		if ( value == null || "".equals ( value ) )
		{
			return value;
		}
		
		value = value.replaceAll ( "<" , "&lt;" ).replaceAll ( ">" , "&gt;" );
		value = value.replaceAll ( "\\(" , "&#40;" ).replace ( "\\)" , "&#41;" );
		value = value.replaceAll ( "'" , "&#39;" );
		value = value.replaceAll ( "eval\\((.*)\\)" , "" );
		value = value.replaceAll ( "[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']" , "\"\"" );
		value = value.replace ( "script" , "" );
		
		return value;
	}
	
}
