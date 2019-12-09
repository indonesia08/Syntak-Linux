 try {
                Connection con = koneksi .getConnection();
                Statement stmt = con.createStatement();

                String sql = "INSERT INTO xxx;";
                stmt.executeUpdate(sql);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal proses\n"+e);
            }
