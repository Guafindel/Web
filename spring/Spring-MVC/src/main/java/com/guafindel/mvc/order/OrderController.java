package com.guafindel.mvc.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guafindel.mvc.domain.OrderCommand;
import com.guafindel.mvc.domain.OrderItem;

@Controller
@RequestMapping("/order/order")
public class OrderController {

	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {

		return "product/orderForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String order(@ModelAttribute("orders") OrderCommand orders) {
		
		System.out.println(orders.getAddress());
		
		for (OrderItem item : orders.getOrderItems()) {
			System.out.println(item);
		}
		
		return "product/order";
	}
}
