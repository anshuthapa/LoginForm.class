import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class LoginForm extends JFrame{
final private Font mainFont=new Font("Segoe print",Font.BOLD,18);
        JTextField tfEmail;
        JPasswordField pfPassword;


    public void initialize(){

        JLabel lbLoginForm = new JLabel("Login Form",SwingConstsnts.CENTER);
        lbLoginForm.setFont(mainfont);

        JLabel lbEmail=new JLabel("Email");
        lbEmail.setFont(mainFont);


        tfEmail = new JTextField();
        tftEmail.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.setBorder(BorderFactory.cretaeEmptyBorder(30,50,30,50));

        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);


        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener(){

            @Override
            public void actionPerfpormed(ActionEvent e){
                String email = tfEmail.getText();
                String password = String.valueOf(pfOassword.getPassword());

                User user = getAuthenticationUser(email,password);
                if (user != null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.initialize(user);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(LoginForm.this,
                    "Email or Password Invalid",
                    "Try again",JOptionPane.ERROR_MESSAGE);
                    
                }
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        JPanel buttonsPannel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30,50,30,50))
    
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btn|Cancel);


        add(formPanel,BorderLayout.NORTH);
        add(buttonsPanel,BorderLayout.SOUTH);
        
        setTitle("LoginForm");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);
        setMinimumSize(new Dimension(350,450));
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private User getAuthenticaticatedUser(String email,String password)
    {
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost/mystore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            String sql = "SELECT * FROM user WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            PreparedStatement.setString(1,email);
            PreparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.name = resultSet.getString("phone");
                user.name = resultSet.getString("password");
            }

            preparedStatement.close();
            conn.close();
        }catch(Exception e){
            System.out.println("Database connection failed");
        }

        return user;
    }

    public static void main(String[] args){
        LoginForm loginForm = new LoginForm();
        loginForm.initialize();
    }
}