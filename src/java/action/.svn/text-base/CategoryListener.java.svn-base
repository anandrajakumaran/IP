/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import hibdao.CategoryDao;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Anand
 */
public class CategoryListener  implements ServletContextListener {
    
    ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("Inside Category Listener");
        CategoryDao categoryDao = new CategoryDao();
        context = contextEvent.getServletContext();
        context.setAttribute("categories", categoryDao.fetchCategories());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
