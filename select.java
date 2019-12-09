 try {
            Connection con = koneksi .getConnection();
            Statement stmt = con.createStatement();            
            int no=1;
            String sql = "SELECT * from tabel;";
            java.sql.Statement stm=con.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
            }            
            jTable1.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
