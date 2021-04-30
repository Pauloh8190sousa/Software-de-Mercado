package tool;

import java.text.NumberFormat;
import java.util.Locale;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.TextField;

public class CampoFormatadoText extends TextField{
	private NumberFormat format;
    private SimpleDoubleProperty amount;
    private TextField campo;
    public CampoFormatadoText(Locale locale, TextField campo) {
    	this(locale, 0.00, campo);
    }
    
	public CampoFormatadoText(Locale locale, Double initialAmount, TextField campo) {
        this.campo = campo;
		this.campo.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        amount = new SimpleDoubleProperty(this, "amount", initialAmount);
        format = NumberFormat.getCurrencyInstance(locale);
        this.campo.setText(format.format(initialAmount));

        // Remove selection when textfield gets focus
        this.campo.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            Platform.runLater(() -> {
                int lenght = getText().length();
                selectRange(lenght, lenght);
                positionCaret(lenght);
            });
        });
        
        // Listen the text's changes
        this.campo.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                formatText(newValue);
            }
        });
        
    }

    /**
     * Get the current amount value
     * @return Total amount
     */
    public Double getAmount() {
        return amount.get();
    }

    /**
     * Property getter
     * @return SimpleDoubleProperty
     */
    public SimpleDoubleProperty amountProperty() {
        return this.amount;
    }

    /**
     * Change the current amount value
     * @param newAmount
     */
    public void setAmount(Double newAmount) {
        if(newAmount >= 0.0) {
            amount.set(newAmount);
            formatText(format.format(newAmount));
        }
    }

    /**
     * Set Currency format
     * @param locale
     */
    public void setCurrencyFormat(Locale locale) {
        format = NumberFormat.getCurrencyInstance(locale);
        formatText(format.format(getAmount()));
    }

    private void formatText(String text) {
        if(text != null && !text.isEmpty()) {
            String plainText = text.replaceAll("[^0-9]", "");

            while(plainText.length() < 3) {
                plainText = "0" + plainText;
            }

            StringBuilder builder = new StringBuilder(plainText);
            builder.insert(plainText.length() - 2, ".");

            Double newValue = Double.parseDouble(builder.toString());
            amount.set(newValue);
            this.campo.setText(format.format(newValue));
        }
    }

    @Override
    public void deleteText(int start, int end) {
        StringBuilder builder = new StringBuilder(campo.getText());
        builder.delete(start, end);
        formatText(builder.toString());
        campo.selectRange(start, start);
    }
    public TextField getCampo(){
    	return campo;
    }
}
