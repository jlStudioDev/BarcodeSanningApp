package Exceptions;

import android.content.Context;
import android.widget.Toast;

public class ToastExceptions {
	
	Context context;
	public ToastExceptions(Context context){
		this.context = context;
	}
	
	public void showToast(String errorMessge){
		Toast toast = Toast.makeText(context, errorMessge, Toast.LENGTH_SHORT);
    	toast.show();
	}
	
}
