package systemui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import controller.ISystemController;
import controller.SystemController;

public class CheckoutHistory extends JFrame implements LibWindow {
	public static final CheckoutHistory INSTANCE = new CheckoutHistory();
    ISystemController ci = new SystemController();
	private boolean isInitialized = false;
	private JPanel topPanel; //panel containing table
	private JPanel middlePanel;
	private JTable table;
	private JScrollPane scrollPane;
	private CustomTableModel model;
	private JButton button;
	private List<String[]> tableData;
	
	//table data and config
	private final String[] DEFAULT_COLUMN_HEADERS 
	   = {"Book Title", "ISBN", "Checkout Date", "Due Date"};
	private static final int SCREEN_WIDTH = 680;
	private static final int SCREEN_HEIGHT = 480;
	private static final int TABLE_WIDTH = (int) (0.75 * SCREEN_WIDTH);
    private static final int DEFAULT_TABLE_HEIGHT = (int) (0.75 * SCREEN_HEIGHT);
    
    //these numbers specify relative widths of the columns -- 
    //they  must add up to 1
    private final float [] COL_WIDTH_PROPORTIONS =
    	{0.25f, 0.25f, 0.25f, 0.25f};
    
    private CheckoutHistory() {}
    
	public void init(List<String[]> arr) {
		tableData = arr;
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		getContentPane().add(mainPanel);
		setValues(model);
		isInitialized = true;
	}
	
	private void defineTopPanel() {
		topPanel = new JPanel();
		createTableAndTablePane();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(scrollPane);		
	}
	
	private void createTableAndTablePane() {
		updateModel(); 
		table = new JTable(model);
		createCustomColumns(table, TABLE_WIDTH,
	            COL_WIDTH_PROPORTIONS, DEFAULT_COLUMN_HEADERS);
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(
				new Dimension(TABLE_WIDTH, DEFAULT_TABLE_HEIGHT));
		scrollPane.getViewport().add(table);
	}
	
	private void createCustomColumns(JTable table, int width, float[] proportions,
		  String[] headers) {
		table.setAutoCreateColumnsFromModel(true);
        int num = headers.length;
        for(int i = 0; i < num; ++i) {
            TableColumn column = new TableColumn(i);
            column.setHeaderValue(headers[i]);
            column.setMinWidth(Math.round(proportions[i]*width));
            table.addColumn(column);
        }
	}
	
	private void setValues(CustomTableModel model) {
		
		List<String[]> data = new ArrayList<>();
		for(String[] arr : tableData) {
			data.add(arr);
		}
		model.setTableValues(data);
		
	}
	public void updateModel(List<String[]> list){
		if(model == null) {
			model = new CustomTableModel();
		}
		model.setTableValues(list);
	}
	
	private void updateModel() {
		List<String[]> theData = new ArrayList<String[]>();
		updateModel(theData);
	}
	
	
	private void defineMiddlePanel(){
		middlePanel=new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		button = new JButton("<= Back to Main");
		middlePanel.add(button);
		addBackButtonListener(button);
	}
	
	private void addBackButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
		});
	}
	
	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Checkout Summary");
		centerFrameOnDesktop(this);
		setSize(SCREEN_WIDTH,SCREEN_HEIGHT); 
		setResizable(false);
	}
	
	public static void centerFrameOnDesktop(Component f) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width  = toolkit.getScreenSize().width;
        int frameHeight = SCREEN_WIDTH;
        int frameWidth  = SCREEN_HEIGHT;
        f.setLocation(((width-frameWidth)/2),(height-frameHeight)/2);    
    }
	
//	public static void main(String[] args) {		
//		EventQueue.invokeLater(new Runnable()
//		{
//			public void run() {
//				TableExample mf = new TableExample();
//				mf.setVisible(true);
//			}
//		});
//	}
	

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		isInitialized = val;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
