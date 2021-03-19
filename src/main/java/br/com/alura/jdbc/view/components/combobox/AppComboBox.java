package br.com.alura.jdbc.view.components.combobox;

import java.util.List;

import javax.swing.JComboBox;

import br.com.alura.jdbc.modelo.Categoria;

public class AppComboBox extends JComboBox<Categoria>{

	private static final long serialVersionUID = 1L;

	public AppComboBox(List<Categoria> categorias) {
		this.setBounds(10, 105, 265, 20);
		this.addItem(new Categoria(0, "Selecione"));
		for (Categoria categoria : categorias) {
			this.addItem(categoria);
		}
	}
	
	@Override
	public Categoria getSelectedItem() {
		return (Categoria) super.getSelectedItem();
	}
}
