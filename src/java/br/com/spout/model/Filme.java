/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spout.model;

/**
 *
 * @author rodrigo
 */
public class Filme {

    private Integer id;
    private String titulo;
    private String sinopse;
    private String genero;
    private String capa;
    private String fanart;
    private String Classificação;
    private String path;
    private String thumbnail;
    private String data;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getFanart() {
        return fanart;
    }

    public void setFanart(String fanart) {
        this.fanart = fanart;
    }

    public String getClassificação() {
        return Classificação;
    }

    public void setClassificação(String Classificação) {
        this.Classificação = Classificação;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", titulo=" + titulo + ", sinopse=" + sinopse + ", genero=" + genero + ", capa=" + capa + ", fanart=" + fanart + ", Classifica\u00e7\u00e3o=" + Classificação + ", path=" + path + ", thumbnail=" + thumbnail + ", data=" + data + '}';
    }   
    
}
