/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ZznamnhizZ
 */
public class ChatLieu {
    Integer idChatLieu;
    String maChatLieu;
    String tenChatLieu;
    String ghichu;

    public ChatLieu() {
    }

    public ChatLieu(Integer idChatLieu, String maChatLieu, String tenChatLieu, String ghichu) {
        this.idChatLieu = idChatLieu;
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.ghichu = ghichu;
    }

    public Integer getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(Integer idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
}
