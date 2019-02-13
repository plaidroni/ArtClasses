import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        DefaultListModel<String> listmodel;
        JList<String> list1;

        JFrame.setDefaultLookAndFeelDecorated(true);
        final JFrame frame = new JFrame("Desert Art Academy Login Session");
        JPanel panel = new JPanel();



        frame.setLayout(new BorderLayout( ));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        listmodel = new DefaultListModel<>();
        list1 = new JList<>(listmodel);
        panel.add(list1);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Clients");
        JMenuItem openMenuItem = new JMenuItem("Create New Client", KeyEvent.VK_O);
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        frame.add(panel);
        menuBar.add(fileMenu);
        frame.add(menuBar);
        frame.setJMenuBar(menuBar);


        BufferedReader br = new BufferedReader(new FileReader("Clients.txt"));
        String st = null;
        JTree tree;
        ArrayList<String> clientsArray = new ArrayList<>();
        ArrayList<String> erasemysuffering = new ArrayList<>();
        DefaultMutableTreeNode clientsRoot = new DefaultMutableTreeNode("Clients");
        try{ while ((st = br.readLine()) != null){
            System.out.println(st);
            clientsArray.add(st);
            System.out.println(clientsArray.size());
        }}
        catch(Exception IOException){
            System.out.println("IOException has Occurred.");
        }
        System.out.println(clientsArray);
        for(int i = 0; i < clientsArray.size(); i++){
            for(int x = 0; x < clientsArray.get(i).split("```").length; x++){

                erasemysuffering.add(clientsArray.get(i).split("```")[x]);
            }

            DefaultMutableTreeNode clientNode = new DefaultMutableTreeNode(erasemysuffering.get(0) + " " + erasemysuffering.get(1) );
            clientsRoot.add(clientNode);
        }

        tree = new JTree(clientsRoot);
        panel.add(tree);
        frame.add(tree);
        frame.pack();
        frame.setSize(400,550);
        openMenuItem.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int classes=0,age=0;
                String fName=null,lName=null,address=null,telephone=null;

                JPanel newClient = new JPanel();

                JTextField fNameField = new JTextField(5);
                JTextField lNameField = new JTextField(5);
                JTextField addressField = new JTextField(5);
                JTextField telephoneField = new JTextField(5);
                JTextField classesField = new JTextField(5);
                JTextField ageField = new JTextField(5);


                newClient.add(new JLabel("First Name:"));
                newClient.add(fNameField);

                newClient.add(new JLabel("Last Name:"));
                newClient.add(lNameField);
                newClient.add(new JLabel("Address:"));
                newClient.add(addressField);

                newClient.add(new JLabel("Telephone:"));
                newClient.add(telephoneField);
                newClient.add(new JLabel("Classes:"));
                newClient.add(classesField);

                newClient.add(new JLabel("Age:"));
                newClient.add(ageField);

                int result = JOptionPane.showConfirmDialog(null, newClient,
                        "Please enter client information", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    fName = fNameField.getText();
                    lName = lNameField.getText();
                    address = addressField.getText();
                    telephone = telephoneField.getText();
                    classes = Integer.parseInt(classesField.getText());
                    age = Integer.parseInt(ageField.getText());
                }

                Client clientToAdd = new Client(address, telephone, fName, lName, classes, age);
                try {
                    usingBufferedWriter(clientToAdd);
                }
                catch(Exception IOException){
                    System.out.println("IOException has Occurred.");
                }
            }

        });
    }
    private static void usingBufferedWriter(Client tenant) throws IOException
    {
        String fileName = "Clients.txt";
        String fileContent = tenant.getFirstName() + "```" + tenant.getLastName() + "```" + tenant.getAddress() + "```" + tenant.getPhoneNumber() + "```" + tenant.getClasses() + "```" + tenant.getAge() + "\n";
        File file = new File(fileName);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fr);
        System.out.println(fileContent);
        writer.write(fileContent);
        writer.write("\n");
        writer.close();
        fr.close();
        System.out.println("Success");
    }
}