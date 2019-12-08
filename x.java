        if (txt_kredit_nomor_rekening.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "GAGAL PROSES TRANSAKSI\nBuka data nasabah terlebih dahulu");
            txt_nomor_rekening.requestFocus();
        } else {
        try {
            String nomor_rekening   =txt_debit_nomor_rekening.getText();
            int jumlah              =Integer.parseInt(txt_debit_jumlah.getText());
            int saldo               =Integer.parseInt(txt_saldo.getText());
            String catatan          =txt_debit_catatan.getText();
            int saldo_update         =saldo-jumlah;

            Connection con = db_config.getConnection();
            Statement stmt = con.createStatement();              
            String sql = "INSERT INTO `java_kel_3`.`tabel_transaksi` (`no_rekening`, `io`, `jenis_transaksi`, `debit`,`saldo`, `keterangan`, `id_operator_add`,`waktu_add`,`ip_device_add`) VALUES ('"+nomor_rekening+"', 'out', 'TARIK VIA TELLER', '"+jumlah+"', '"+saldo_update+"','"+catatan+"', "+UserSession.get_us_id_operator()+",NOW(),CONCAT(SUBSTRING_INDEX(USER(), '@', 2),':',@@port,'*',@@hostname,'*',DATABASE()));";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.execute();     
            
            String sql2 = "Update tabel_rekening set saldo="+saldo_update+" where no_rekening='"+nomor_rekening+"';";
            java.sql.PreparedStatement pst2=con.prepareStatement(sql2);
            pst2.execute(); 
            JOptionPane.showMessageDialog(null, "Transaksi berhasil di proses");
            txt_debit_jumlah.setText("");
            txt_debit_catatan.setText("");
            fungsi_open_rekening();
            //load_table();
        } catch (Exception e) {        
            JOptionPane.showMessageDialog(null, "GAGAL PROSES TRANSAKSI\n"+e);
        }    
        }
        
        
                String nomor_rekening   =txt_kredit_nomor_rekening.getText();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("#");
        model.addColumn("NO REKENING");
        model.addColumn("NAMA TRANSAKSI");
        model.addColumn("DEBIT");
        model.addColumn("KREDIT");
        model.addColumn("SALDO");
        model.addColumn("KETERANGAN");
        //menampilkan data database kedalam tabel
        try {
            Connection con = db_config.getConnection();
            //Statement stmt = con.createStatement();
            int no=1;
            String sql = "SELECT no_rekening,jenis_transaksi,debit,kredit,saldo,keterangan FROM `tabel_transaksi` WHERE no_rekening='"+nomor_rekening+"' ORDER BY no_transaksi ASC;";
            java.sql.Statement stm=con.createStatement();
            ResultSet           res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }            
            jTable1.setModel(model);
        } catch (Exception e) {
        }
