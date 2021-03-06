/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author Berkant
 */
public class Floor {
    int fid;
    int bid;
    String fname;
    ArrayList<Room> rooms = new ArrayList<>();

    public Floor(int fid, int bid, String fname) {
        this.fid = fid;
        this.bid = bid;
        this.fname = fname;
    }
    
    public Floor(int bid, String fname) {
        this.bid = bid;
        this.fname = fname;
    }

    public Floor() {
    }

    
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    
    public void reinitRooms(){
        rooms = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Floor{" + "fid=" + fid + ", bid=" + bid + ", fname=" + fname + ", rooms=" + rooms + '}';
    }
   

}
