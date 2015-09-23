/**
 * 
 */
package com.ask.mtradus.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ASK
 *
 */
@Controller
@RequestMapping("/product")
public class ProductDetailsController {

	@RequestMapping("/vendors")
	public void listVendors() {
		
	}
}
