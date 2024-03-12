package transport;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FillterClass implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException { 
		
		 chain.doFilter(req, res);
		 
	}

}
