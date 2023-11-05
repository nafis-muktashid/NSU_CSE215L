import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class UserInterface extends JFrame {

    ArrayList<Company> categorizedCompany, arrayListFromFile;
    static final String DATA_FILE = "data.txt";
    JButton signIn, addCompInfo, showCompInfo, saveToFile, deleteCompInfo, editCompInfo, backDelete;
    JTextField username;
    JPanel introMain, introLogIn, afterSignIn;
    static boolean showButtonClicked = false, deleteButtonClicked = false, editButtonClicked = false;
    static boolean b = true ;
    JTable table;
    JScrollPane tableScrollPane;
    static DefaultTableModel model;



    UserInterface(){
        categorizedCompany = new ArrayList<>();
        arrayListFromFile = new ArrayList<>();
        initializeUI();
        loadDataFromFile();
    }



    private void initializeUI(){

        //----------------------- Frame --------------------------
        this.setTitle("Skill Connect");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);



        //----------------------- TextFields -----------------------
                    // Username field
        username = new JTextField();
        username.setSize(350, 30);
        username.setFont(new Font("Arial", Font.BOLD, 20));
        username.setBorder(BorderFactory.createCompoundBorder());



        //---------------------- Table ---------------------------
        model = new DefaultTableModel(new Object[]{"Industry", "Company ID", "Company Name", "Designation", "Employee Count", "Income"}, 0);
        table = new JTable(model);
        tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(984, 500));
        tableScrollPane.setBounds(0, 0, 984, 500);
        tableScrollPane.setVisible(false);



        //---------------------- Buttons ----------------------------
                    // Sign-In Button
        signIn = new JButton();
        signIn.setText("Sign In");
        signIn.setSize(100,30);
        signIn.setFont(new Font("Arial", Font.BOLD, 15));
        signIn.setBackground(Color.WHITE);
        signIn.setFocusable(false);

                    // Add-Company-Info Button
        addCompInfo = new JButton();
        addCompInfo.setText("ADD INFO");
        addCompInfo.setSize(120,35);
        addCompInfo.setFont(new Font("Arial", Font.BOLD, 13));
        addCompInfo.setBackground(Color.WHITE);
        addCompInfo.setFocusable(false);

                    // Show-Company-Info button
        showCompInfo = new JButton();
        showCompInfo.setText("SHOW INFO");
        showCompInfo.setSize(120,35);
        showCompInfo.setFont(new Font("Arial", Font.BOLD, 13));
        showCompInfo.setBackground(Color.WHITE);
        showCompInfo.setFocusable(false);

                    // Save-Button
        saveToFile = new JButton();
        saveToFile.setText("SAVE INFO");
        saveToFile.setSize(120,35);
        saveToFile.setFont(new Font("Arial", Font.BOLD, 13));
        saveToFile.setBackground(Color.WHITE);
        saveToFile.setFocusable(false);

                    // Delete-Button
        deleteCompInfo = new JButton();
        deleteCompInfo.setText("DELETE INFO");
        deleteCompInfo.setSize(120, 35);
        deleteCompInfo.setFont(new Font("Arial", Font.BOLD, 13));
        deleteCompInfo.setBackground(Color.WHITE);
        deleteCompInfo.setFocusable(false);

                    // Edit-Button
        editCompInfo = new JButton();
        editCompInfo.setText("EDIT INFO");
        editCompInfo.setSize(120, 35);
        editCompInfo.setFont(new Font("Arial", Font.BOLD, 13));
        editCompInfo.setBackground(Color.WHITE);
        editCompInfo.setFocusable(false);

                    // Back-Button
        backDelete = new JButton();
        backDelete.setText("BACK");
        backDelete.setSize(120,35);
        backDelete.setFont(new Font("Arial", Font.BOLD, 13));
        backDelete.setBackground((Color.WHITE));
        backDelete.setFocusable(false);
        backDelete.setVisible(false);




        //------------------- Logos ------------------------
        ImageIcon namePic = new ImageIcon("logo_1.png");        //// Name With Logo
        ImageIcon logo = new ImageIcon("logo_2.png");           //// Application icon on the task bar.
        JLabel nameLogo = new JLabel();
        nameLogo.setHorizontalAlignment(JLabel.CENTER);
        nameLogo.setVerticalAlignment(JLabel.CENTER);
        nameLogo.setIcon(namePic);


        //----------------- Main panel blue name part --------------------------
        introMain = new JPanel();                                       //// Works like a container. Can have components like frame.
        introMain.setBackground(new Color(0x000000));
        introMain.setLayout(new BorderLayout());
        introMain.setOpaque(true);
        introMain.setBounds(0,0, 492,561);
        introMain.add(nameLogo);
        this.add(introMain);


        //---------------- Main panel Login part ----------------------
        introLogIn = new JPanel();
        introLogIn.setOpaque(true);
        introLogIn.setBackground(new Color(0x123456));
        introLogIn.setLayout(null);
        introLogIn.setBounds(492,0,492,561);
        introLogIn.add(signIn); // signInButton
            signIn.setLocation(195, 290);
            signIn.addActionListener(e -> {
                /*String s = username.getText();
                if(Objects.equals(s, "CE0")){
                    introMain.setVisible(false);
                    introLogIn.setVisible(false);
                    afterSignIn.setVisible(true);
                }*/
                introMain.setVisible(false);
                introLogIn.setVisible(false);
                afterSignIn.setVisible(true);
            });
            introLogIn.add(username);
            username.setLocation(75, 250);
        this.add(introLogIn);


        //--------------- After Login Panel panel ------------------------
        afterSignIn = new JPanel();
        afterSignIn.setVisible(false);
        afterSignIn.setLayout(null);
        afterSignIn.setSize(984,561);
        afterSignIn.setBackground(new Color(0x123456));


            //Add Button
            afterSignIn.add(addCompInfo);
            addCompInfo.setLocation(430,180);
            addCompInfo.addActionListener(e -> {

                String industry = JOptionPane.showInputDialog("Enter Industry");
                int company_id = Integer.parseInt(JOptionPane.showInputDialog("Enter Company ID"));
                String company_name = JOptionPane.showInputDialog("Enter Company Name");
                String designation = JOptionPane.showInputDialog("Enter Designation");
                int employeeCount = Integer.parseInt(JOptionPane.showInputDialog("Enter How Many Employee"));
                double income = Double.parseDouble(JOptionPane.showInputDialog("Enter Income"));
                income *= employeeCount;

                Company newObj = new Company(industry, company_id, company_name,designation,employeeCount,income);

                categorizedCompany.add(newObj);
            });



            //Save Button
            afterSignIn.add(saveToFile);
            saveToFile.setLocation(430, 220);
            saveToFile.addActionListener(e ->{
                saveDataToFile();
                showButtonClicked = false;
            });



            //Show Button
            afterSignIn.add(showCompInfo);
            showCompInfo.setLocation(430,310);
            showCompInfo.addActionListener(e -> {
                loadDataFromFile();
                if(!showButtonClicked){
                    createAndShowTable();
                    showButtonClicked = true;
                }
            });



            //Delete Button
            afterSignIn.add(deleteCompInfo);
            deleteCompInfo.setLocation(430, 265);

            deleteCompInfo.addActionListener(e -> {

                saveToFile.setVisible(false);
                showCompInfo.setVisible(false);
                addCompInfo.setVisible(false);
                deleteCompInfo.setVisible(false);
                editCompInfo.setVisible(false);

                afterSignIn.add(tableScrollPane);

                afterSignIn.add(backDelete);
                backDelete.setVisible(true);
                backDelete.setLocation(430,515);

                loadDataFromFile();

                if(!showButtonClicked){
                    createAndShowTable();
                    table.setVisible(true);
                    tableScrollPane.setVisible(true);
                }

                afterSignIn.revalidate();
                afterSignIn.repaint();

                deleteButtonClicked = true;

            });
            table.getSelectionModel().addListSelectionListener(ex -> {
                if(deleteButtonClicked){
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        int choice = JOptionPane.showConfirmDialog(null, "Do you want to delete this row?", "Row Selected", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            model.removeRow(selectedRow);
                            loadDataFromTable(table);
                        }
                    }
                }else if(editButtonClicked){
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        String companyName = (String) model.getValueAt(selectedRow, 2);
                        int currentEmployeeCount = (Integer.parseInt(model.getValueAt(selectedRow, 4).toString()));
                        double currentIncome = (Double.parseDouble(model.getValueAt(selectedRow, 5).toString()));
                        double temp = currentIncome / currentEmployeeCount;

                        String input = JOptionPane.showInputDialog(this, "Edit How many employee for " + companyName, currentEmployeeCount);

                        try {
                            int newEmployeeCount = Integer.parseInt(input);
                            model.setValueAt(newEmployeeCount, selectedRow, 4);
                            model.setValueAt(newEmployeeCount * temp, selectedRow, 5);

                            loadDataFromTable(table);

                        } catch (NumberFormatException exc) {
                            System.out.println("***INVALID FORMAT***");
                        }
                    }
                }
            });

            //Back Button
            backDelete.addActionListener(ex -> {
                showCompInfo.setLocation(200,515);
                addCompInfo.setLocation(330,515);
                saveToFile.setLocation(460,515);
                deleteCompInfo.setLocation(590,515);
                editCompInfo.setLocation(720,515);

                backDelete.setVisible(false);
                showCompInfo.setVisible(true);
                addCompInfo.setVisible(true);
                saveToFile.setVisible(true);
                deleteCompInfo.setVisible(true);
                editCompInfo.setVisible(true);

                deleteButtonClicked = false;
                editButtonClicked = false;
            });



            //Edit Button
            afterSignIn.add(editCompInfo);
            editCompInfo.setLocation(430,350);
            afterSignIn.add(tableScrollPane);
            editCompInfo.addActionListener(e -> {
                loadDataFromFile();

                if(!showButtonClicked){
                    createAndShowTable();
//                    table.setVisible(true);
                    tableScrollPane.setVisible(true);
                }
                editButtonClicked = true;

            });



        this.add(afterSignIn);




        //------------------ Frame Characteristics -----------

        this.setIconImage(logo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(true);
        this.setVisible(true);
    }



    private void loadDataFromTable(JTable table) {
        arrayListFromFile.clear();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            String industry = (String) model.getValueAt(row, 0);
            int companyId = (Integer.parseInt(model.getValueAt(row, 1).toString())) ;
            String companyName = (String) model.getValueAt(row, 2);
            String designation = (String) model.getValueAt(row, 3);
            int employeeCount = (Integer.parseInt(model.getValueAt(row, 4).toString()));
            double income = (Double.parseDouble(model.getValueAt(row, 5).toString()));

            Company obj = new Company(industry, companyId, companyName,designation,employeeCount,income);

            arrayListFromFile.add(obj);
        }
        saveTableToFile();
    }


    private void loadDataFromFile() {
        arrayListFromFile = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(DATA_FILE));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 6) {
                    String industryName = parts[0];
                    int cmpID = Integer.parseInt(parts[1]);
                    String cmpName = parts[2];
                    String cmpDesignation = parts[3];
                    int countEmp = Integer.parseInt(parts[4]);
                    double income = Double.parseDouble(parts[5]);

                    Company obj = new Company(industryName, cmpID, cmpName,cmpDesignation,countEmp,income);

                    arrayListFromFile.add(obj);
                }else{
                    throw new CanNotReadException();
                }
            }

        } catch (CanNotReadException e) {
            System.out.println((e.getMessage()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    private void saveDataToFile() {
        try {
            FileWriter writer = new FileWriter(DATA_FILE, true);
            for (Company obj : categorizedCompany) {
                writer.write(obj.toString());
            }
            if (categorizedCompany.isEmpty()){
                throw new CanNotReadException();
            }
            writer.close();
            categorizedCompany.clear();
        } catch (IOException e) {
            System.out.println("***COULD NOT WRITE***");
        } catch (CanNotReadException e) {
            System.out.println(e.getMessage());
        }
    }



    private void saveTableToFile(){
        try{
            FileWriter writer = new FileWriter(DATA_FILE);
            if(arrayListFromFile.isEmpty()){
                throw new CanNotReadException();
            }
            for(Company obj : arrayListFromFile){
                writer.write((obj.toString()));
            }
            writer.close();
        }catch (CanNotReadException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private void createAndShowTable() {

        showCompInfo.setLocation(200,515);
        addCompInfo.setLocation(330,515);
        saveToFile.setLocation(460,515);
        deleteCompInfo.setLocation(590,515);
        editCompInfo.setLocation(720,515);


        if(!b) {
            int i ;
            for(i=0; i<arrayListFromFile.size()-1; ++i){
                model.setValueAt((arrayListFromFile.get(i)).getIndustry(), i, 0);
                model.setValueAt((arrayListFromFile.get(i)).getCompanyIds()+"", i, 1);
                model.setValueAt((arrayListFromFile.get(i)).getCompanyNames(), i, 2);
                model.setValueAt((arrayListFromFile.get(i)).getDesignations(), i, 3);
                model.setValueAt((arrayListFromFile.get(i)).getHowManyEmployee()+"", i, 4);
                model.setValueAt((arrayListFromFile.get(i)).getIncome()+"", i, 5);

            }
            model.addRow(new Object[] {arrayListFromFile.get(i).getIndustry(),arrayListFromFile.get(i).getCompanyIds(),arrayListFromFile.get(i).getCompanyNames(),
                    arrayListFromFile.get(i).getDesignations(),arrayListFromFile.get(i).getHowManyEmployee(),arrayListFromFile.get(i).getIncome()});

        }
        if(b) {
            b= false ;

            for (Company obj : arrayListFromFile) {
                model.addRow(new String[]{obj.getIndustry(), String.valueOf(obj.getCompanyIds()), obj.getCompanyNames(),
                        obj.getDesignations(), String.valueOf(obj.getHowManyEmployee()), String.valueOf(obj.getIncome())});
            }
        }

        tableScrollPane.setVisible(true);
        afterSignIn.add(tableScrollPane);

        afterSignIn.revalidate();
        afterSignIn.repaint();
        afterSignIn.setVisible(true);

    }
}
