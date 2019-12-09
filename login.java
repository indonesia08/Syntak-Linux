 String username     =txt_username.getText();
        String password     =new String(txt_password.getPassword());
        try {
            Connection con = Koneksi2.getConnection();
            Statement stmt = con.createStatement();
            
            sql = "SELECT * FROM tabel_operator WHERE nik='"+username+"' AND password_login='"+password+"';";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                if(username.equals(rs.getString("nik"))){
                    System.out.println(Integer.parseInt(rs.getString("nik")));

                    Home call_home=new Home();
                    call_home.setExtendedState(Home.MAXIMIZED_BOTH);
                    call_home.setVisible(true);
                    this.dispose();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
