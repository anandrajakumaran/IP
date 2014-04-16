/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

import hibernate.Category;
import java.util.List;

/**
 *
 * @author DealGuru
 */
public interface CategoryDaoInterface {
    
        public List<Category> fetchCategories();
        public Category getCategoryId(Short categoryId); 
}
