import java.util.ArrayList;
/**
 *
 * @author Brandon FIfield Student ID: 201238730
 */
public class ProductList {
   
   private ArrayList<Product> list;
   
   public ProductList() {
       list = new ArrayList<>();
   }
   
   public void addProduct(Product p) {
       list.add(p);
   }
   
   public ArrayList<Product> getList() {
       return list;
   }
   
   
   
   public String toString() {
       String stringList = "";
       for(Product l: list) {
          stringList = stringList + l.toString();
       }
       return stringList;
   }
}
