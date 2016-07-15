package com.br.model.dao;

import com.br.connection.ConectionFactory;
import com.br.model.to.MercadoriaTO;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class MercadoriaDAO {
    public int inserirMercadoria(MercadoriaTO mercadoriaTO) {
        String sqlInsert = "INSERT INTO mercadoria(tipo_mercadoria,nome_mercadoria,quantidade,preco,tipo_negocio) VALUES(?,?,?,?,?)";

        try (Connection conn = new ConectionFactory().getConnection();) {
            PreparedStatement stm = conn.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, mercadoriaTO.getTipoMercadoria());
            stm.setString(2, mercadoriaTO.getNomeMercadoria());
            stm.setInt(3, mercadoriaTO.getQuantidade());
            stm.setDouble(4, mercadoriaTO.getPreco());
            stm.setString(5, mercadoriaTO.getTipoNegocio());
            stm.execute();
            final ResultSet rs = stm.getGeneratedKeys();
            if(rs.next()){
            	return rs.getInt("id_mercadoria");
            }
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
    }

    public ArrayList<String> carregaTipoMercadoria() {

        String sql = "SELECT DISTINCT tipo_mercadoria FROM mercadoria";
        ArrayList<String> tipo = new ArrayList<>();
        try (Connection conn = new ConectionFactory().getConnection();) {
            PreparedStatement stm = conn.prepareStatement(sql);
            
            try (ResultSet rs = stm.executeQuery()) {
            	while (rs.next()) {
            		tipo.add(rs.getString("tipo_mercadoria"));

                }
            	rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1);
        }
        return tipo;
    }
    public ArrayList<MercadoriaTO> carregarFiltros(Map<String,String> filtros) {
    	String concatenacao = "";
    	for( String fil : filtros.keySet()){
    		if(fil.equals("tipo_mercadoria") && !filtros.get(fil).isEmpty() ){
    			concatenacao += " tipo_mercadoria like '" + filtros.get(fil) + "' AND";
    		}
    		if(fil.equals("nome_mercadoria") && !filtros.get(fil).isEmpty() ){
    			concatenacao += " nome_mercadoria like '" + filtros.get(fil) + "' AND";
    		}
    		if(fil.equals("tipo_negocio") && !filtros.get(fil).isEmpty() ){
    			concatenacao += " tipo_negocio like '" + filtros.get(fil) + "' AND";
    		}
    		
    		

    		
    	}
    		

    	concatenacao = concatenacao.trim();
    	if( !concatenacao.isEmpty()){
    		concatenacao = "WHERE " + concatenacao;
        	if ( concatenacao.substring(concatenacao.length() - 3,concatenacao.length()).equals("AND") ){
        		concatenacao =  concatenacao.substring(0,concatenacao.length() - 3);
        	}	
    	}
        String sql = "SELECT * FROM mercadoria " + concatenacao;
        System.out.println(sql);
        ArrayList<MercadoriaTO> mercadoTO = new ArrayList<>();
        
        try (Connection conn = new ConectionFactory().getConnection();) {
            PreparedStatement stm = conn.prepareStatement(sql);
            
            try (ResultSet rs = stm.executeQuery()) {
            	while (rs.next()) {
            		MercadoriaTO merc = new MercadoriaTO();
            		merc.setiDMercadoria(rs.getInt("id_mercadoria"));
            		merc.setNomeMercadoria(rs.getString("nome_mercadoria"));
            		merc.setPreco(rs.getDouble("preco"));
            		merc.setQuantidade(rs.getInt("quantidade"));
            		merc.setTipoMercadoria(rs.getString("tipo_mercadoria"));
            		merc.setTipoNegocio(rs.getString("tipo_negocio"));
            		mercadoTO.add(merc);
            		
                }
            	rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1);
        }
        
        return mercadoTO;
    }
}
