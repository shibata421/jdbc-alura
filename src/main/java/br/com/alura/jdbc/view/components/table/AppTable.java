package br.com.alura.jdbc.view.components.table;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.alura.jdbc.modelo.Produto;
import br.com.alura.jdbc.view.ProdutoCategoriaFrame;

public class AppTable extends JTable {

	private static final long serialVersionUID = 1L;
	private ProdutoCategoriaFrame frame;
	private DefaultTableModel modelo;

	public AppTable(ProdutoCategoriaFrame frame) {
		this.setBounds(10, 185, 760, 300);
		this.frame = frame;
		modelo = (DefaultTableModel) super.getModel(); 
		modelo.addColumn("Identificador do Produto");
		modelo.addColumn("Nome do Produto");
		modelo.addColumn("Descrição do Produto");
		preencherTabela();
	}
	
	public void preencherTabela() {
		List<Produto> produtos = frame.listarProdutos();
		try {
			for (Produto produto : produtos) {
				modelo.addRow(new Object[] { produto.getId(), produto.getNome(), produto.getDescricao() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void limparTabela() {
		modelo.getDataVector().clear();
	}
	
	public void alterar() {
		Object objetoDaLinha = (Object) modelo.getValueAt(this.getSelectedRow(), this.getSelectedColumn());
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			String nome = (String) modelo.getValueAt(this.getSelectedRow(), 1);
			String descricao = (String) modelo.getValueAt(this.getSelectedRow(), 2);
			frame.alterarProduto(nome, descricao, id);
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
		}
	}

	public void deletar() {
		Object objetoDaLinha = (Object) modelo.getValueAt(this.getSelectedRow(), this.getSelectedColumn());
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			frame.deletarProduto(id);
			modelo.removeRow(this.getSelectedRow());
			JOptionPane.showMessageDialog(this, "Item excluído com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
		}
	}
}
