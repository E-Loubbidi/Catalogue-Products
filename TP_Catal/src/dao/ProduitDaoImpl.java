package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Produit;

public class ProduitDaoImpl implements IProduitDao{

	@Override
	public Produit save(Produit p) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into PRODUITS(DESIGNATION, PRIX, QUANTITE) values(?, ?, ?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("select MAX(ID) as MAX_ID from PRODUITS");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return p;
	}

	@Override
	public List<Produit> produitParMc(String mc) {
		// TODO Auto-generated method stub
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("Select * from PRODUITS WHERE DESIGNATION like ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p =new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getLong("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return produits;
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		Produit p = null;
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("Select * from PRODUITS WHERE ID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getLong("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("update PRODUITS set DESIGNATION = ?, PRIX = ?, QUANTITE = ? where ID = ?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from PRODUITS where ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void init() {
		System.out.println("Initialisation ...");
	}

}
