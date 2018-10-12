package com.example.listsdemo;

public class Student {

   private String name,address;
   private int profilePic;

   public Student(String name,String address,int profilePic){
       this.name=name;
       this.address=address;
       this.profilePic=profilePic;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }
}
