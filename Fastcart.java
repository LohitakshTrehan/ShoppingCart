import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import javax.swing.table.*;
public class Fastcart {
  JFrame f;
  Fastcart(){
    f=new JFrame("JAVA Project");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //creating instance of JFrame

    /*****************************************************************************************
			Panel 1
    *****************************************************************************************/
    JPanel panel1=new JPanel();
    panel1.setBounds(10,10,200,150);
    panel1.setBackground(Color.black);
    JLabel l1,ll1;
    l1=new JLabel("WELCOME TO");
    l1.setBounds(20,40,160,18);
    l1.setFont(new Font("Serif", Font.BOLD, 22));
    l1.setForeground(Color.red);
    ll1=new JLabel("FAST-CART");
    ll1.setBounds(30,80,150,22);
    ll1.setFont(new Font("Serif", Font.BOLD, 25));
    ll1.setForeground(Color.red);
    panel1.add(l1);panel1.add(ll1);
    panel1.setLayout(null);
    /*****************************************************************************************
			Panel 2
    *****************************************************************************************/
    JPanel panel2=new JPanel();
    panel2.setBounds(220,10,210,150);
    panel2.setBackground(Color.lightGray);
    JLabel l2;
    l2=new JLabel("Select Category :");
    l2.setBounds(20,30,120,20);
    l2.setFont(new Font("Serif", Font.BOLD, 16));
    JComboBox category=new JComboBox();
    category.setBounds(20,60,150,50);
    category.addItem("Mobile and Tablets");category.addItem("Computers");category.addItem("Electronics");
    category.addItem("Storage");category.addItem("All Categories");
    panel2.add(category);
    panel2.add(l2);
    panel2.setLayout(null);
    /*****************************************************************************************
			Panel 3
    *****************************************************************************************/
    JPanel panel3=new JPanel();
    panel3.setBounds(440,10,510,150);
    panel3.setBackground(Color.lightGray);
    JLabel l3;
    l3=new JLabel("Filters :");
    l3.setBounds(10,10,80,20);
    l3.setFont(new Font("Serif", Font.BOLD, 14));
    ButtonGroup cbg = new ButtonGroup();
    JRadioButton priceRB = new JRadioButton("PRICE");
    priceRB.setBounds(20,40,100,30);

    JRadioButton WarrantyRB = new JRadioButton("Warranty");
    WarrantyRB.setBounds(130,40,100,30);
    JRadioButton NoneRB = new JRadioButton("None");
    NoneRB.setBounds(240,40,100,30);
    NoneRB.setSelected(true);
    cbg.add(priceRB);
    cbg.add(WarrantyRB);
    cbg.add(NoneRB);
    JLabel l4;
    l4=new JLabel("Lower Limit :");
    l4.setBounds(10,110,90,20);
    l4.setFont(new Font("Serif", Font.BOLD, 14));
    JTextField LL;
    LL=new JTextField();
    LL.setBounds(100,110,80,20);
    LL.setEditable(false);
    JLabel l5;
    l5=new JLabel("Upper Limit :");
    l5.setBounds(190,110,90,20);
    l5.setFont(new Font("Serif", Font.BOLD, 14));
    JTextField UL;
    UL=new JTextField();
    UL.setBounds(280,110,80,20);
    UL.setEditable(false);
    JButton b=new JButton("Search");
    b.setBounds(400,40,80,80);
//**********
priceRB.addActionListener(new ActionListener()
    {
         public void actionPerformed(ActionEvent e)
         {
	if(priceRB.isSelected()==true)
	{
	     LL.setEditable(true);
	     UL.setEditable(true);
	}
         }
    });
WarrantyRB.addActionListener(new ActionListener()
    {
         public void actionPerformed(ActionEvent e)
         {
	if(WarrantyRB.isSelected()==true)
	{
	     LL.setEditable(true);
	     UL.setEditable(true);
	}
         }
    });
NoneRB.addActionListener(new ActionListener()
    {
         public void actionPerformed(ActionEvent e)
         {
	if(NoneRB.isSelected()==true)
	{
	     LL.setEditable(false);
	     UL.setEditable(false);
	}
         }
    });

//*********
    panel3.add(priceRB);panel3.add(WarrantyRB);panel3.add(NoneRB);
    panel3.add(l3);panel3.add(l4);panel3.add(l5);
    panel3.add(LL);panel3.add(UL);
    panel3.add(b);
    panel3.setLayout(null);
    /*****************************************************************************************
			Panel 4
    *****************************************************************************************/
    JPanel panel4=new JPanel();
   JScrollPane scr=new JScrollPane();
    panel4.setBounds(10,180,250,250);
    panel4.setBackground(Color.lightGray);
    JLabel l6;
    l6=new JLabel("Search Results :");
    l6.setBounds(70,10,120,20);
    l6.setFont(new Font("Serif", Font.BOLD, 16));
    JList<String> itemlist = new JList<>(new DefaultListModel());
    /*itemlist.setBounds(10,40,230,200);*/
   scr.setBounds(10,40,230,200);
   scr.setViewportView(itemlist);
    panel4.add(l6);
    panel4.add(scr);
    panel4.setLayout(null);


    /******************************************************************************************
			Panel 5
    *****************************************************************************************/
    JPanel panel5=new JPanel();
    panel5.setBounds(270,180,680,250);
    panel5.setBackground(Color.lightGray);
    JLabel l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField code,name,description,warranty,price,categorytf,qtys,oqty;
    l7=new JLabel("Item Details");
    l7.setFont(new Font("Serif", Font.BOLD, 18));
    l7.setBounds(280,10,120,20);
    //
    l8=new JLabel("Item Code:");
    l8.setBounds(10,40,80,20);
    code=new JTextField();
    code.setBounds(90,40,120,20);
    code.setEditable(false);
    //
    l9=new JLabel("Name:");
    l9.setBounds(10,70,80,20);
    name=new JTextField();
    name.setBounds(90,70,500,20);
    name.setEditable(false);
    //
    l10=new JLabel("Description:");
    l10.setBounds(10,100,80,20);
    description=new JTextField();
    description.setBounds(90,100,500,20);
    description.setEditable(false);
    //
    l11=new JLabel("Price:");
    l11.setBounds(10,130,80,20);
    price=new JTextField();
    price.setBounds(90,130,120,20);
    price.setEditable(false);
    //
    l12=new JLabel("Warranty:");
    l12.setBounds(220,130,80,20);
    warranty=new JTextField();
    warranty.setBounds(300,130,120,20);
    warranty.setEditable(false);
    //
    l13=new JLabel("Category:");
    l13.setBounds(430,130,80,20);
    categorytf=new JTextField();
    categorytf.setBounds(510,130,120,20);
    categorytf.setEditable(false);
    //
    l14=new JLabel("Qty available:");
    l14.setBounds(10,160,120,20);
    qtys=new JTextField();
    qtys.setBounds(130,160,120,20);
    qtys.setEditable(false);
    //
//***************************************************ItemListListener***************************************/

itemlist.addListSelectionListener(new ListSelectionListener(){
	public void valueChanged(ListSelectionEvent v)
	{
		if(!v.getValueIsAdjusting())
		{
			String sval = (String) itemlist.getSelectedValue();
        String q = "select * from fastcart where IName = '"+ sval + "' ;";
        try{
             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shopping?autoReconnect=true&useSSL=false","root","java") ;

           Statement s2 = con.createStatement();
           ResultSet rs1 = s2.executeQuery(q);

           rs1.next();
           {
               code.setText("" + rs1.getInt(1));
               name.setText(rs1.getString(2));
               description.setText(rs1.getString(3));
               categorytf.setText(rs1.getString(4));
               price.setText("" + rs1.getInt(5));
               qtys.setText("" + rs1.getInt(6));
               warranty.setText("" + rs1.getInt(7) + " years");

           }
           rs1.close();
           con.close();
           s2.close();
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null,"Error in Connectivity");}
		}
	}
});
    JCheckBox buycb = new JCheckBox("Click here to process your order");
buycb.setSelected(false);
    buycb.setBounds(10,190,250,20);
    //
    l15=new JLabel("Order Quntity:");
    l15.setBounds(300,190,80,20);
    oqty=new JTextField();
    oqty.setBounds(380,190,120,20);
    oqty.setEditable(false);
    //
    JButton AddToCartbtn=new JButton("ADD to Cart");
    AddToCartbtn.setBounds(250,220,120,20);
    //
    panel5.add(l7);panel5.add(l8);panel5.add(l9);panel5.add(l10);panel5.add(l11);
    panel5.add(l12);panel5.add(l13);panel5.add(l14);panel5.add(l15);
    panel5.add(code);panel5.add(name);panel5.add(description);panel5.add(price);panel5.add(warranty);
    panel5.add(categorytf);panel5.add(qtys);panel5.add(oqty);
    panel5.add(buycb);panel5.add(AddToCartbtn);
    panel5.setLayout(null);
//**********************************************************
buycb.addItemListener(new ItemListener()
{
	public void itemStateChanged(ItemEvent ie)
	{
		if(buycb.isSelected())
        { oqty.setEditable(true);}
        else{oqty.setEditable(false);}
	}
});
    /*****************************************************************************************
			Panel 6
    *****************************************************************************************/
    JPanel panel6=new JPanel();
    panel6.setBounds(10,440,940,250);
    panel6.setBackground(Color.lightGray);
JScrollPane scr2=new JScrollPane();
    String column[]={"Itemcode","Name","Price","Qty. Ordered","Amount"};
    JTable Items=new JTable();
scr2.setBounds(30,50,880,170);
    Items.setEnabled(false);
	DefaultTableModel dtm=new DefaultTableModel(0,0);
	dtm.setColumnIdentifiers(column);
	Items.setModel(dtm);
scr2.setViewportView(Items);

    JLabel l16=new JLabel("CART");
    l16.setBounds(430,10,80,20);
    l16.setFont(new Font("Serif", Font.BOLD, 16));
    panel6.add(scr2);
    panel6.add(l16);
    panel6.setLayout(null);

    /*****************************************************************************************
			Panel 7
    *****************************************************************************************/
    JPanel panel7=new JPanel();
    panel7.setBounds(10,700,940,70);
    JLabel l22;
    JTextField finalamt;
    panel7.setBackground(Color.lightGray);
    l22=new JLabel("TOTAL AMOUNT TO BE PAYED(Rs.) :");
    l22.setFont(new Font("Serif", Font.BOLD, 13));
    l22.setBounds(30,20,230,20);
    finalamt=new JTextField();
    finalamt.setText("0");
    finalamt.setBounds(270,20,120,20);
    finalamt.setEditable(false);
    JButton Buybtn=new JButton("BUY");
    Buybtn.setBounds(600,20,120,20);
    JButton Exitbtn=new JButton("EXIT");
    Exitbtn.setBounds(800,20,120,20);
    panel7.add(l22);panel7.add(Buybtn);panel7.add(Exitbtn);panel7.add(finalamt);
    panel7.setLayout(null);
//******************************************Search Button****************************************/
b.addActionListener(new ActionListener()
    {
         public void actionPerformed(ActionEvent e)
         {
DefaultListModel m1 =  (DefaultListModel) itemlist.getModel();
          String a = "Select * from fastcart";
          switch(category.getSelectedIndex())
          {case 0 : a = a + " where category = 'Mobiles and Tablets'"; break;
           case 1 : a = a + " where category = 'Computers' "; break;
           case 2 : a = a + " where category = 'Electronics' "; break;
           case 3 : a = a + " where category = 'Storage' "; break;
           case 4 : a = a ; break;
           }
          int lower = 0;
          int higher = 0;
          if(NoneRB.isSelected()== false)
          { lower = Integer.parseInt(LL.getText());
           higher = Integer.parseInt(UL.getText());}

          if(priceRB.isSelected()==true)
          {if(category.getSelectedIndex()==4)
            {a= a + " where price between "+ lower + " and " + higher + " ; ";}
          else  {a = a + " and price between " + lower + " and " + higher + " ; ";}
          }

          else if(WarrantyRB.isSelected()==true)
          {if(category.getSelectedIndex()==4)
            {a= a + " where warranty between "+ lower + " and " + higher + " ;";}
          else  {a = a + " and warranty between " + lower + " and " + higher + " ;" ;}
         }
          else { a = a + " ; " ;}
    try{
            int count = 0;
           Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shopping?autoReconnect=true&useSSL=false","root","java") ;

           Statement s1 = con.createStatement();
           ResultSet rs = s1.executeQuery(a);
         if(rs.isBeforeFirst()==true)
          {while(rs.next())
           { m1.add(count , rs.getString("IName"));
             count ++;
             }
          rs.close();
          s1.close();
          con.close();}
         else{JOptionPane.showMessageDialog(null,"No such items Available"); }
}
catch(Exception ex)
{
	ex.printStackTrace();
}

 }

    });
//******************************************************AddToCartbtn****************************************/
AddToCartbtn.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)
	{
try{
       int orderqty = Integer.parseInt(oqty.getText());
        int avqty = Integer.parseInt(qtys.getText());
        int pri = Integer.parseInt(price.getText());
        String s1 = "";
 if(avqty>=orderqty)
        {  Object[] QO1 = { code.getText() , name.getText() , price.getText() , oqty.getText() , pri*orderqty } ;
            dtm.addRow(QO1);
            int n=0; int d;
            for(int m=0 ; m <dtm.getRowCount() ; m++ )
            { d = (int) dtm.getValueAt(m, 4);
              n = n + Integer.parseInt(""+d);
            }
           finalamt.setText(""+n);

        }
        else{int sq = orderqty-avqty ;
int  a1= JOptionPane.showConfirmDialog(null,"Ordered qty is greater than available quantity of the ordered product by " + sq + " \n" + "We regret for the inconvinience caused. \n" + "Do you want to update the ordered quantity?");
if(a1==0)
            { s1 = JOptionPane.showInputDialog("Enter new quantity");
              oqty.setText(s1);
              JOptionPane.showMessageDialog(null,"Ordered Quantity updated succesfully"); }    }

}
catch(Exception ee)
{
	JOptionPane.showMessageDialog(null,"Please enter quantity");
}
}});
/*****************************************************Buybtn***************************************************/
Buybtn.addActionListener(new ActionListener()
    {
         public void actionPerformed(ActionEvent ee)
         {
	int am = Integer.parseInt(finalamt.getText());
        if(am==0)
        JOptionPane.showMessageDialog(null,"No item in the cart");
        else{
        int n8 = JOptionPane.showConfirmDialog(null,"You have ordered for a total of Rs. "+am +"\n Do you want to confirm the order?");
        if(n8==0)
        {try
        {  Class.forName("com.mysql.jdbc.Driver") ;
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shopping?autoReconnect=true&useSSL=false","root","java");
           Statement st = con.createStatement();
           int n=0;
           String d,e,q;
            for(int m=0 ; m < dtm.getRowCount() ; m++ )
            { d = (String) dtm.getValueAt(m,0);
              e = (String) dtm.getValueAt(m,3);
             q = "update fastcart set qty = qty -"+e+" where ICode = "+d+" ;";
             System.out.println(q);
             st.executeUpdate(q);
            }
               code.setText("" );
               name.setText("");
               description.setText("");
               categorytf.setText("");
               price.setText("");
               qtys.setText("");
               warranty.setText("");
            con.close();
            st.close();
		int c=dtm.getRowCount();
             for(int m=0 ; m < c; m++ )
            { 	dtm.removeRow(0);
	}
	finalamt.setText("0");
         }
        catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null,"Error in Connectivity");
         }}
         }}
    });
/******************************Exitbtn***************************************************************************/
Exitbtn.addActionListener(new ActionListener()
    {
         public void actionPerformed(ActionEvent ee)
         {
	int n =  JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
        	if(n==0)
        	{System.exit(0);}
         }
    });
    /*************************************************************************************
		Adding Panels to frame
    *************************************************************************************/
    f.add(panel1);f.add(panel2);f.add(panel3);f.add(panel4);
    f.add(panel5);f.add(panel6);f.add(panel7);
    f.setSize(960,800);//400 width and 500 height
    f.setLayout(null);//using no layout managers
    f.setVisible(true);//making the frame visible
  }

  public static void main(String[] args) {
    new Fastcart();
  }
}
