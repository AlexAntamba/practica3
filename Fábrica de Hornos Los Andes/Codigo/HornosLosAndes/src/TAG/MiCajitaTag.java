package TAG;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MiCajitaTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value = "";
	
	public void setValue(String valor){
		value = valor;
	}
	
	public int doStartTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			out.println("<input type='text' value='" + value + "' />");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
