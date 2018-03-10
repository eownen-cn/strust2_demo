package org.denny.struts;
import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	public String execute() {
		boolean successOrError = Math.random() > 0.5 ;
		if (successOrError) System.out.println("return the string of success Or Error by the number of random=> " + successOrError); 
		else if (!successOrError) System.err.println("return the string of success Or Error by the number of random=> " + successOrError); 
		return successOrError ? SUCCESS : ERROR ;
	}
	
	
}
