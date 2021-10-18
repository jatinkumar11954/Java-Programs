package New;

import java.util. * ;

public class Task {
  static int total = 0;
  void authentication(String userName, String pwd) {

    System.out.println(userName);
    String u = "Team3",
    p = "123456";
    if (userName.equals(u)) {
      if (pwd.equals(p)) {
        System.out.println("Authentication Successfull!!!");
      }
      else {

        System.out.println("Please Enter correct Password!!!");

      }
    }
    else {

      System.out.println("Please Enter correct UserName!!!");
    }
  }

  void calculatePrice(int main, int sub) {

    Product p = new Product();
    total += p.price.get(main).get(sub);

  }

  void selectSubProduct(int selectProduct) {
    Product p = new Product();
    int mainIndex;
    List < List < String >> subProduct = p.subproduct;
    Scanner s = new Scanner(System. in );
    System.out.println("Please Select the Sub Category of " + p.mainProduct.get(selectProduct) + " :--");
    for (int i = 0; i < subProduct.get(selectProduct).size(); i++) {
      System.out.println(i + "--" + subProduct.get(selectProduct).get(i));
    }
    mainIndex = s.nextInt();
    if (mainIndex < p.subproduct.get(selectProduct).size())

    {

      System.out.println("This is your Selected Sub Category of " + p.mainProduct.get(selectProduct) + " " + mainIndex + "--" + subProduct.get(selectProduct).get(mainIndex));

      calculatePrice(selectProduct, mainIndex);

    } else if (mainIndex >= p.mainProduct.size()) {
      System.out.println("Invalid Choice of Sub Product!!!");
      k = 1;

    }

  }
  static int k = 0;
  //---------------------------------
  void selectProduct() {
    Product p = new Product();

    List < String > mainProduct = p.mainProduct;
    Scanner s = new Scanner(System. in );

    int mainIndex = 0;

    while (k != 1) {
      System.out.println("  !!!Welcome to the Product Store!!!  \n");
      if (total == 0) System.out.println("Please Select the Product:--");
      if (total > 0)

      System.out.println("Please Select the Product(/Enter 11 to Checkout):--");

      for (int i = 0; i < mainProduct.size(); i++) {
        System.out.println(i + "--" + mainProduct.get(i));
      }

      mainIndex = s.nextInt();
      if (mainIndex != 11 && mainIndex < mainProduct.size()) {
        System.out.println("This is your Selected Product-- " + mainIndex + "--" + mainProduct.get(mainIndex));

        selectSubProduct(mainIndex);
      }
      else if (mainIndex != 11 && mainIndex >= mainProduct.size()) {

        System.out.println("Invalid Choice!!!");

      }
      else {
        System.out.println("Thank you for Choosing Us!!!");

        System.out.println("This is your Net Price " + total);
        k = 1;
      }

    }

  }

  //------------------------------
  public static void main(String[] args) {
    Scanner s = new Scanner(System. in );
    String userName,
    pwd;
    System.out.println("Please Enter the UserName:--");
    userName = s.next();

    System.out.println("Please Enter the Password:--");
    pwd = s.next();
    Task t = new Task();
    t.authentication(userName, pwd);
    t.selectProduct();
  }
}

class Product {

  List < String > mainProduct = Arrays.asList("Tv", "Monitor", "KeyBoard", "Mouse");
  List < List < String >> subproduct = Arrays.asList(Arrays.asList("Normal--Rs.150", "Smart--Rs.160"), Arrays.asList("LED--Rs.170", "LCD--Rs.180"), Arrays.asList("Wired--Rs.200", "WireLess--Rs.300"), Arrays.asList("Wired--Rs.500", "WireLess--Rs.450"));
  List < List < Integer >> price = Arrays.asList(Arrays.asList(150, 160), Arrays.asList(170, 180), Arrays.asList(200, 300), Arrays.asList(500, 450));

}
