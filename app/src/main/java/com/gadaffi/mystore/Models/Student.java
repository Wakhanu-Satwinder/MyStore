package com.gadaffi.mystore.Models;

public class Student {

       String name;
        String email;
         String regno;
        String phoneno;
        String unique_id;
        String password;
        String old_password;
        String new_password;

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getUnique_id() {
            return unique_id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public void setRegno(String regno) {
            this.regno=regno;
        }
        public void setPhoneno(String phoneno) {
            this.phoneno=phoneno;
        }
        public void setPassword(String password) {
            this.password = password;
        }

        public void setOld_password(String old_password) {
            this.old_password = old_password;
        }

        public void setNew_password(String new_password) {
            this.new_password = new_password;
        }

}

