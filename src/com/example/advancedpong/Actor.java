package com.example.advancedpong;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;

public class Actor extends Activity
{
	protected Point position;
	protected Point lastPosition;
	protected float speed;
	protected int height;
	protected int width;
	protected Bitmap bitmap;
	
	public float getX()
	{
		return this.position.x;
	}
	
	public void setX(int x)
	{
		this.position.set(x, this.position.y);
	}
	
	public float getY()
	{
		return this.position.y;
	}

	public void setY(int y)
	{
		this.position.set(this.position.x, y);
	}
	
	public int getLastX()
	{
		return this.lastPosition.x;
	}
	
	public void setLastPosition(int x, int y)
	{
		this.lastPosition = new Point(x, y);
	}
	
	public void setLastPosition(Point position)
	{
		this.lastPosition = new Point(position);
	}
	
	public float getSpeed()
	{
		return this.speed;
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}
	
	public Bitmap getBitmap()
	{
		return this.bitmap;
	}
	
	public void setBitmap(Bitmap bitmap)
	{
		this.bitmap = bitmap;
	}
	
	public int left()
	{
		return (int) this.position.x;
	}
	
	public int right()
	{
		return (int) this.position.x + this.width;
	}
	
	public int top()
	{
		return (int) this.position.y;
	}
	
	public int bottom()
	{
		return (int) this.position.y + this.height;
	}
	
	public float angle; /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Actor(Resources resources, int resourceID, Point position, float speed, float angle)
	{
		this.position = position;
		this.speed = speed;
		this.angle = angle;
		this.bitmap = BitmapFactory.decodeResource(resources, resourceID);
		this.height = bitmap.getHeight();
		this.width = bitmap.getWidth();
	}
	
	protected void Draw(Canvas canvas)
	{
		canvas.drawBitmap(this.bitmap, this.position.x, this.position.y, null);
	}
	
	public float direction = 270;
	
	protected void Update(double timeElapsed)
	{
		this.lastPosition = this.position;
		
		double radians = (Math.PI / 180) * this.angle;
		this.position.x += this.speed * Math.cos(radians);
		this.position.y += this.speed * Math.sin(radians);
		
		//this.x += timeElapsed * this.speedX;
		//this.y += timeElapsed * this.speedY;
	}
}
