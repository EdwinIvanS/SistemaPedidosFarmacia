
import javax.swing.SwingUtilities;
import com.farmacia.pedidos.view.FormularioPedido;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
            FormularioPedido formulario = new FormularioPedido();
            formulario.setVisible(true);
        });
	}

}
