package com.example.advancedpong;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class Ball extends Actor
{
	public Ball(Resources resources, float x, float y, double velocityX, double velocityY)
	{
		super(resources, R.drawable.ball, x, y, velocityX, velocityY);
	}
	
	public void Draw(Canvas canvas)
	{
		super.Draw(canvas);
	}
	
	public void Update(double timeElapsed)
	{
		super.Update(timeElapsed);
		
		Context context = MainApplication.getContext();
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
    	Point size = new Point();
    	display.getSize(size);
    	int width = size.x;
    	int height = size.y;
		
		if (x <= 0 || x + this.width >= width)
		{
			velocityX *= -1; 
		}
		
		if (y <= 0 || y + this.height >= height)
		{
			velocityY *= -1; 
		}
	}
}