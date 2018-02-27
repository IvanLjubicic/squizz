package com.dia.squizz;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContinueGame extends Activity implements OnClickListener {

	private static final int BUTTON_POSITIVE = 0;
	Button question, answera, answerb, answerc, answerd, next, sendRes;
	TextView tvpoints, tvbonus;
	String temp = null;
	Cursor c = null;
	int points, bonus, flag, min, max;
	DataBaseHelper myDbHelper;
	Global glob;
	Random generator = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.continuegame);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		initialize();
		goplay();

	}

	private void goplay() {
		// TODO Auto-generated method stub
		try {

			myDbHelper.createDataBase();

		} catch (IOException ioe) {

			throw new Error("Unable to create database");

		}
		try {

			myDbHelper.openDataBase();

		} catch (SQLException sqle) {

			throw sqle;

		}

		c = myDbHelper.retCursor();
		currentQuestion();
		myDbHelper.close();
	}

	private void currentQuestion() {
		// TODO Auto-generated method stub
		tvpoints.setText("Points: " + points);
		answera.setEnabled(true);
		answerb.setEnabled(true);
		answerc.setEnabled(true);
		answerd.setEnabled(true);
		answera.setTextColor(Color.BLACK);
		answerb.setTextColor(Color.BLACK);
		answerc.setTextColor(Color.BLACK);
		answerd.setTextColor(Color.BLACK);
		if (bonus > -5 && bonus < 5) {
			tvbonus.setText("No bonus");
		} else if (bonus >= 5 && bonus < 10) {
			tvbonus.setText("Bonus");
		} else if (bonus >= 10 && bonus < 20) {
			tvbonus.setText("Double bonus");
		} else if (bonus >= 20 && bonus < 40) {
			tvbonus.setText("Triple bonus");
		} else if (bonus >= 40 && bonus < 100) {
			tvbonus.setText("Monster bonus");
		} else if (bonus >= 100) {
			tvbonus.setText("Golden bonus");
		} else if (bonus <= -5 && bonus > -10) {
			tvbonus.setText("Negative strike");
		} else if (bonus <= -10 && bonus > -20) {
			tvbonus.setText("Double negative bonus");
		} else if (bonus <= -20 && bonus > -40) {
			tvbonus.setText("Combo negative bonus");
		} else if (bonus <= -40 && bonus > -100) {
			tvbonus.setText("Disaster bonus");
		} else if (bonus <= -100) {
			tvbonus.setText("Catastrophe bonus");
		}

		// Toast.makeText(this,"globalna var min" + glob.getMin() +
		// "glob var max " + glob.getMax() + "Points: " + glob.getPoints(),
		// Toast.LENGTH_LONG).show();
		c.moveToPosition(glob.getPosit());
		question.setText(c.getString(c.getColumnIndex("question")));
		answera.setText(c.getString(c.getColumnIndex("answerA")));
		answerb.setText(c.getString(c.getColumnIndex("answerB")));
		answerc.setText(c.getString(c.getColumnIndex("answerC")));
		answerd.setText(c.getString(c.getColumnIndex("answerD")));

	}

	private void nextQuestion() {
		// TODO Auto-generated method stub
		tvpoints.setText("Points: " + points);
		answera.setEnabled(true);
		answerb.setEnabled(true);
		answerc.setEnabled(true);
		answerd.setEnabled(true);
		answera.setTextColor(Color.BLACK);
		answerb.setTextColor(Color.BLACK);
		answerc.setTextColor(Color.BLACK);
		answerd.setTextColor(Color.BLACK);
		if (bonus > -5 && bonus < 5) {
			tvbonus.setText("No bonus");
		} else if (bonus >= 5 && bonus < 10) {
			tvbonus.setText("Bonus");
		} else if (bonus >= 10 && bonus < 20) {
			tvbonus.setText("Double bonus");
		} else if (bonus >= 20 && bonus < 40) {
			tvbonus.setText("Triple bonus");
		} else if (bonus >= 40 && bonus < 100) {
			tvbonus.setText("Monster bonus");
		} else if (bonus >= 100) {
			tvbonus.setText("Golden bonus");
		} else if (bonus <= -5 && bonus > -10) {
			tvbonus.setText("Negative strike");
		} else if (bonus <= -10 && bonus > -20) {
			tvbonus.setText("Double negative bonus");
		} else if (bonus <= -20 && bonus > -40) {
			tvbonus.setText("Combo negative bonus");
		} else if (bonus <= -40 && bonus > -100) {
			tvbonus.setText("Disaster bonus");
		} else if (bonus <= -100) {
			tvbonus.setText("Catastrophe bonus");
		}

		/*
		 * Toast.makeText( this, "globalna var min" + glob.getMin() +
		 * "glob var max " + glob.getMax() + "Bonus: " + bonus,
		 * Toast.LENGTH_LONG).show();
		 */
		c.moveToPosition(randomNumber(min, max));
		question.setText(c.getString(c.getColumnIndex("question")));
		answera.setText(c.getString(c.getColumnIndex("answerA")));
		answerb.setText(c.getString(c.getColumnIndex("answerB")));
		answerc.setText(c.getString(c.getColumnIndex("answerC")));
		answerd.setText(c.getString(c.getColumnIndex("answerD")));
	}

	public static int randomNumber(int min, int max) {
		return min + (new Random()).nextInt(max - min);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		question = (Button) findViewById(R.id.bQuestion);
		question.setOnClickListener(this);
		answera = (Button) findViewById(R.id.bAnswerA);
		answera.setOnClickListener(this);
		answerb = (Button) findViewById(R.id.bAnswerB);
		answerb.setOnClickListener(this);
		answerc = (Button) findViewById(R.id.bAnswerC);
		answerc.setOnClickListener(this);
		answerd = (Button) findViewById(R.id.bAnswerD);
		answerd.setOnClickListener(this);
		next = (Button) findViewById(R.id.bNext);
		next.setOnClickListener(this);
		sendRes = (Button) findViewById(R.id.bSendResults);
		sendRes.setOnClickListener(this);
		tvpoints = (TextView) findViewById(R.id.tvPoints);
		tvbonus = (TextView) findViewById(R.id.tvBonus);
		glob = ((Global) getApplicationContext());
		myDbHelper = new DataBaseHelper(this);
		points = glob.getPoints();
		bonus = glob.getBonus();
		flag = glob.getFlag();
		min = glob.getMin();
		max = glob.getMax();
		/*
		 * Toast.makeText( this, "flag je" + flag + " min je" + min + " max je"
		 * + max + "points je " + points, Toast.LENGTH_LONG).show();
		 */
		// c = myDbHelper.retCursor();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();

	}

	@SuppressWarnings("deprecation")
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bAnswerA:
			if (answera.getText().toString()
					.equals(c.getString(c.getColumnIndex("correctA")))) {
				points++;
				answera.setText("Correct");
				answera.setTextColor(Color.BLUE);
				if (bonus <= -5 && flag == 0) {
					if (bonus <= -100) {
						points += -100;
					} else if (bonus <= -40) {
						points += -40;
					} else if (bonus <= -20) {
						points += -20;
					} else if (bonus <= -10) {
						points += -10;
					} else {
						points += -5;
					}
					bonus = 1;
				} else
					bonus++;
				flag = 1;
			} else {
				points--;
				answera.setText("Incorrect");
				answera.setTextColor(Color.RED);
				if (bonus >= 5 && flag == 1) {
					if (bonus >= 100) {
						points += 100;
					} else if (bonus >= 40) {
						points += 40;
					} else if (bonus >= 20) {
						points += 20;
					} else if (bonus >= 10) {
						points += 10;
					} else {
						points += 5;
					}
					bonus = -1;
				} else
					bonus--;
				flag = 0;
			}
			answera.setEnabled(false);
			answerb.setEnabled(false);
			answerc.setEnabled(false);
			answerd.setEnabled(false);
			break;
		case R.id.bAnswerB:
			if (answerb.getText().toString()
					.equals(c.getString(c.getColumnIndex("correctA")))) {
				points++;
				answerb.setText("Correct");
				answerb.setTextColor(Color.BLUE);
				if (bonus <= -5 && flag == 0) {
					if (bonus <= -100) {
						points += -100;
					} else if (bonus <= -40) {
						points += -40;
					} else if (bonus <= -20) {
						points += -20;
					} else if (bonus <= -10) {
						points += -10;
					} else {
						points += -5;
					}
					bonus = 1;
				} else
					bonus++;
				flag = 1;
			} else {
				points--;
				answerb.setText("Incorrect");
				answerb.setTextColor(Color.RED);
				if (bonus >= 5 && flag == 1) {
					if (bonus >= 100) {
						points += 100;
					} else if (bonus >= 40) {
						points += 40;
					} else if (bonus >= 20) {
						points += 20;
					} else if (bonus >= 10) {
						points += 10;
					} else {
						points += 5;
					}
					bonus = -1;
				} else
					bonus--;
				flag = 0;
			}
			answera.setEnabled(false);
			answerb.setEnabled(false);
			answerc.setEnabled(false);
			answerd.setEnabled(false);
			break;
		case R.id.bAnswerC:
			if (answerc.getText().toString()
					.equals(c.getString(c.getColumnIndex("correctA")))) {
				points++;
				answerc.setText("Correct");
				answerc.setTextColor(Color.BLUE);
				if (bonus <= -5 && flag == 0) {
					if (bonus <= -100) {
						points += -100;
					} else if (bonus <= -40) {
						points += -40;
					} else if (bonus <= -20) {
						points += -20;
					} else if (bonus <= -10) {
						points += -10;
					} else {
						points += -5;
					}
					bonus = 1;
				} else
					bonus++;
				flag = 1;
			} else {
				points--;
				answerc.setText("Incorrect");
				answerc.setTextColor(Color.RED);
				if (bonus >= 5 && flag == 1) {
					if (bonus >= 100) {
						points += 100;
					} else if (bonus >= 40) {
						points += 40;
					} else if (bonus >= 20) {
						points += 20;
					} else if (bonus >= 10) {
						points += 10;
					} else {
						points += 5;
					}
					bonus = -1;
				} else
					bonus--;
				flag = 0;
			}
			answera.setEnabled(false);
			answerb.setEnabled(false);
			answerc.setEnabled(false);
			answerd.setEnabled(false);
			break;
		case R.id.bAnswerD:
			if (answerd.getText().toString()
					.equals(c.getString(c.getColumnIndex("correctA")))) {
				points++;
				answerd.setText("Correct");
				answerd.setTextColor(Color.BLUE);
				if (bonus <= -5 && flag == 0) {
					if (bonus <= -100) {
						points += -100;
					} else if (bonus <= -40) {
						points += -40;
					} else if (bonus <= -20) {
						points += -20;
					} else if (bonus <= -10) {
						points += -10;
					} else {
						points += -5;
					}
					bonus = 1;
				} else
					bonus++;
				flag = 1;
			} else {
				points--;
				answerd.setText("Incorrect");
				answerd.setTextColor(Color.RED);
				if (bonus >= 5 && flag == 1) {
					if (bonus >= 100) {
						points += 100;
					} else if (bonus >= 40) {
						points += 40;
					} else if (bonus >= 20) {
						points += 20;
					} else if (bonus >= 10) {
						points += 10;
					} else {
						points += 5;
					}
					bonus = -1;
				} else
					bonus--;
				flag = 0;
			}
			answera.setEnabled(false);
			answerb.setEnabled(false);
			answerc.setEnabled(false);
			answerd.setEnabled(false);
			break;

		case R.id.bNext:
			if (answera.isEnabled() == false)
				nextQuestion();
			else
				Toast.makeText(this, "First you must answer the question",
						Toast.LENGTH_LONG).show();
			break;

		case R.id.bSendResults:		
			AlertDialog alertDialog = new AlertDialog.Builder(ContinueGame.this)
					.create();
			alertDialog.setTitle("Nickname");
			alertDialog.setMessage("Enter nickname");
			final EditText input = new EditText(this);
			alertDialog.setView(input);
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					String nickname = input.getText().toString();
					glob.setNick(nickname);
					Mail m = new Mail("squizz.quiz@gmail.com", "71215805");

					String[] toArr = { "squizz.quiz@gmail.com" };
					m.setTo(toArr);
					m.setFrom("squizz.quiz@gmail.com");
					m.setSubject("Squizz results");
					m.setBody("Nickname: " + glob.getNick() + "\nPoints: "
							+ glob.getPoints() + "\nMin: " + glob.getMin()
							+ "\nMax: " + glob.getMax());

					try {
						if (m.send()) {
							Toast.makeText(ContinueGame.this,
									"Result was sent successfully.",
									Toast.LENGTH_LONG).show();
						} else {
							Toast.makeText(ContinueGame.this,
									"Result was not sent. Please try again", Toast.LENGTH_LONG)
									.show();
							/*Toast.makeText(ContinueGame.this, "Nickname: " + glob.getNick() + "\nPoints: "
									+ glob.getPoints() + "\nMin: " + glob.getMin()
									+ "\nMax: " + glob.getMax(), Toast.LENGTH_LONG).show();*/
						}
					} catch (Exception e) {
						// Toast.makeText(MailApp.this,
						// "There was a problem sending the email.",
						// Toast.LENGTH_LONG).show();
						Log.e("ContinueGame", "Could not send email", e);
					}
					// here you can add functions
				}
			});
			alertDialog.show();
			break;

		}
		glob.setParams(points, bonus, flag, glob.getMin(), glob.getMax(),
				c.getPosition());
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
			// Toast.makeText(this, "Stisnuto je back",
			// Toast.LENGTH_LONG).show();
			glob.setParams(points, bonus, flag, glob.getMin(), glob.getMax(),
					c.getPosition());
			// Toast.makeText(this,"globalna var min" + glob.getMin() +
			// "glob var max " + glob.getMax() + "points: " + glob.getPoints(),
			// Toast.LENGTH_LONG).show();
		
		return super.onKeyDown(keyCode, event);
	}
}
