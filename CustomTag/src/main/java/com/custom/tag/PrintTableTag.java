package com.custom.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintTableTag extends TagSupport {

	public int number;

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int doStartTag() throws JspException {

		try {
			for (int i = 1; i <= 10; i++) {
				JspWriter out = pageContext.getOut();

				out.print("<br>");
				out.println(i * number+"<br>");
				
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
