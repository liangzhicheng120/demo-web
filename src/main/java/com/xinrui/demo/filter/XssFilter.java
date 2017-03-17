package com.xinrui.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @ClassName: XssFilter
 * @Description: Xss跨脚本攻击过滤器
 * @author 梁志成
 * @date 2016年3月17日 下午10:51:25
 *
 */
public class XssFilter implements Filter
{
	
	@Override
	public void destroy ( )
	{
	
	}
	
	@Override
	public void doFilter ( ServletRequest request , ServletResponse response , FilterChain chain )
			throws IOException , ServletException
	{
		chain.doFilter ( request , response );
		
	}
	
	@Override
	public void init ( FilterConfig arg0 ) throws ServletException
	{
	
	}
	
}
