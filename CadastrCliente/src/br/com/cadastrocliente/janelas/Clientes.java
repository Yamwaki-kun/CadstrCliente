package br.com.cadastrocliente.janelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

import br.com.cadastrocliente.banco.DAO;
import br.com.cadastrocliente.dominio.Cidade;
import br.com.cadastrocliente.dominio.Estado;
import br.com.cadastrocliente.enums.TipoLogradouro;

import javax.swing.JTextArea;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private final JPanel pnlDadosPessoais = new JPanel();
	private JTextField txtNomeDoCliente;
	private JTextField txtRg;
	private JTextField lblPai;
	private JTextField txtMae;
	private JTextField txtEmail;
	private JTextField txdLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtPontoDeReferencia;
	private JTextField txtPagInt;
	private JTextField txtDataDeCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/icon/iconfinder_icon-45-note-list_315167.png")));
		setTitle("Cadastro De Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setBounds(10, 34, 103, 14);
		contentPane.add(lblDadosPessoais);
		pnlDadosPessoais.setBackground(Color.WHITE);
		pnlDadosPessoais.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDadosPessoais.setBounds(10, 50, 773, 159);
		contentPane.add(pnlDadosPessoais);
		pnlDadosPessoais.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(10, 11, 96, 14);
		pnlDadosPessoais.add(lblNomeDoCliente);
		
		txtNomeDoCliente = new JTextField();
		txtNomeDoCliente.setBounds(10, 28, 276, 20);
		pnlDadosPessoais.add(txtNomeDoCliente);
		txtNomeDoCliente.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 56, 48, 14);
		pnlDadosPessoais.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(155, 56, 48, 14);
		pnlDadosPessoais.add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setBounds(155, 70, 131, 20);
		pnlDadosPessoais.add(txtRg);
		txtRg.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino", "Outro"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 115, 193, 22);
		pnlDadosPessoais.add(comboBox);
		
		
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 101, 48, 14);
		pnlDadosPessoais.add(lblSexo);
		
		MaskFormatter msk=null;
		try {
			msk= new MaskFormatter("###.###.###-##");
		}
		catch(Exception e) {e.printStackTrace();}
		
		JFormattedTextField txtCpf = new JFormattedTextField(msk);
		txtCpf.setBounds(10, 70, 117, 20);
		pnlDadosPessoais.add(txtCpf);
		
		lblPai = new JTextField();
		lblPai.setBounds(475, 28, 266, 20);
		pnlDadosPessoais.add(lblPai);
		lblPai.setColumns(10);
		
		JLabel lblNomeDoPai = new JLabel("Nome do Pai");
		lblNomeDoPai.setBounds(475, 11, 87, 14);
		pnlDadosPessoais.add(lblNomeDoPai);
		
		JLabel lblNomeDaMe = new JLabel("Nome da m\u00E3e");
		lblNomeDaMe.setBounds(475, 56, 87, 14);
		pnlDadosPessoais.add(lblNomeDaMe);
		
		txtMae = new JTextField();
		txtMae.setBounds(475, 70, 266, 20);
		pnlDadosPessoais.add(txtMae);
		txtMae.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(475, 101, 163, 14);
		pnlDadosPessoais.add(lblDataDeNascimento);
		
		MaskFormatter dt=null;
		try {
			dt= new MaskFormatter("##/##/####");
		}
		catch(Exception e) {e.printStackTrace();}
		
		JFormattedTextField txtData = new JFormattedTextField(dt);
		txtData.setBounds(475, 116, 68, 20);
		pnlDadosPessoais.add(txtData);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 234, 773, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		MaskFormatter tel=null;
		try {
			tel= new MaskFormatter("(##)####-####");
		}
		catch(Exception e) {e.printStackTrace();}
		
		JFormattedTextField txtTelefone = new JFormattedTextField(tel);
		txtTelefone.setBounds(10, 25, 100, 20);
		panel.add(txtTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 11, 60, 14);
		panel.add(lblTelefone);
		
		MaskFormatter cell=null;
		try {
			cell= new MaskFormatter("(##)#####-####");
		}
		catch(Exception e) {e.printStackTrace();}
		
		JFormattedTextField formattedTextField = new JFormattedTextField(cell);
		formattedTextField.setBounds(137, 25, 100, 20);
		panel.add(formattedTextField);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(137, 11, 48, 14);
		panel.add(lblCelular);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(259, 11, 48, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(258, 25, 254, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(10, 220, 62, 14);
		contentPane.add(lblContato);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 315, 773, 112);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTipoDeLogradouro = new JLabel("Tipo De Logradouro");
		lblTipoDeLogradouro.setBounds(23, 57, 130, 14);
		panel_1.add(lblTipoDeLogradouro);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(23, 11, 96, 14);
		panel_1.add(lblLogradouro);
		
		txdLogradouro = new JTextField();
		txdLogradouro.setBounds(23, 26, 298, 20);
		panel_1.add(txdLogradouro);
		txdLogradouro.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(153, 57, 48, 14);
		panel_1.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(153, 74, 62, 20);
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(399, 57, 76, 14);
		panel_1.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(399, 74, 96, 20);
		panel_1.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(225, 57, 48, 14);
		panel_1.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(225, 74, 96, 20);
		panel_1.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(522, 11, 48, 14);
		panel_1.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(399, 11, 48, 14);
		panel_1.add(lblEstado);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(667, 11, 48, 14);
		panel_1.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(667, 26, 96, 20);
		panel_1.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblPontoDeReferencia = new JLabel("Ponto de Referencia");
		lblPontoDeReferencia.setBounds(522, 57, 145, 14);
		panel_1.add(lblPontoDeReferencia);
		
		txtPontoDeReferencia = new JTextField();
		txtPontoDeReferencia.setBounds(522, 74, 241, 20);
		panel_1.add(txtPontoDeReferencia);
		txtPontoDeReferencia.setColumns(10);
		
		JComboBox cbxTipoLogradouro = new JComboBox();
		cbxTipoLogradouro.setBackground(Color.LIGHT_GRAY);
		for(Object t : TipoLogradouro.values()) {
			cbxTipoLogradouro.addItem(t);
			
		}
				
				
		cbxTipoLogradouro.setBounds(23, 73, 96, 22);
		panel_1.add(cbxTipoLogradouro);
		
		int es = 1;
		DAO dao = new DAO();
		
		JComboBox comCidades = new JComboBox();
		comCidades.setBounds(522, 25, 108, 22);
		panel_1.add(comCidades);
		
		
		JComboBox comEstados = new JComboBox();
		comEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int est = comEstados.getSelectedIndex() + 1;
				
				comCidades.removeAllItems();
				
				for(Cidade c : dao.listarCidades(est)) {
					comCidades.addItem(c.getNome());
				}

				
				
			}
		});
		for(Estado e : dao.todos()) {
			comEstados.addItem(e.getNome());
		}
		comEstados.setBounds(399, 25, 96, 22);
		panel_1.add(comEstados);
		
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 302, 48, 14);
		contentPane.add(lblEndereo);
		
		JLabel lblOutro = new JLabel("Outro");
		lblOutro.setBounds(10, 428, 48, 14);
		contentPane.add(lblOutro);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 446, 773, 104);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPginaDeInternet = new JLabel("P\u00E1gina de Internet");
		lblPginaDeInternet.setBounds(615, 11, 111, 14);
		panel_2.add(lblPginaDeInternet);
		
		txtPagInt = new JTextField();
		txtPagInt.setBounds(615, 25, 148, 20);
		panel_2.add(txtPagInt);
		txtPagInt.setColumns(10);
		
		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o");
		lblObservao.setBounds(10, 11, 72, 14);
		panel_2.add(lblObservao);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(10, 23, 592, 70);
		panel_2.add(textArea);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(18, 561, 48, 14);
		contentPane.add(lblStatus);
		
		txtDataDeCadastro = new JTextField();
		txtDataDeCadastro.setBounds(166, 576, 96, 20);
		contentPane.add(txtDataDeCadastro);
		txtDataDeCadastro.setColumns(10);
		
		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro");
		lblDataDeCadastro.setBounds(166, 561, 137, 14);
		contentPane.add(lblDataDeCadastro);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(632, 575, 151, 23);
		contentPane.add(btnCadastrar);
		
		JComboBox comStatus = new JComboBox();
		comStatus.setBackground(Color.LIGHT_GRAY);
		for(Object s : Status.values()) {
			comStatus.addItem(s);
		}
			
			
		comStatus.setBounds(10, 575, 96, 22);
		contentPane.add(comStatus);
	}
}
