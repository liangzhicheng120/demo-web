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
 * @Description: Xss��ű�����������
 * @author ��־��
 * @date 2016��3��17�� ����10:51:25
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
