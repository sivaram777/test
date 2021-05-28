package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello userid %d";
	private static final String templates = "Welcome %s user!";

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "id",required=true,defaultValue = "0") int id,@RequestParam(value = "account",defaultValue = " ") String account,@RequestParam(value = "type",defaultValue = " ") String type) 
	{
		if(checking(id, account))
		{
			if ((account.equalsIgnoreCase("business") || account.equalsIgnoreCase("personal")) && id >= 0 && type.equalsIgnoreCase(" ")) {
				return String.format(template,id);	
			}

			else if((account.equalsIgnoreCase("business") || account.equalsIgnoreCase("personal")) && type.equalsIgnoreCase("big")) {
				return String.format(templates, account);	
			}
			else 
			{
				return "the path is not yet implemented.";
			}
		}
		else {
			return "Error";
		}
	}
	
	static boolean checking(int id,String account) {
		
		if (id >= 0 && (account.equalsIgnoreCase("business") || account.equalsIgnoreCase("personal")))
		{
			return true;
		}
		else {
			return false;
		}
		
		
	}
}