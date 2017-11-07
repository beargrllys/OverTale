package pptprogram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;
public class paint2 extends JPanel implements MouseListener {

	Vector<Point> vf = new Vector<Point>();
	Vector<Point> vs = new Vector<Point>();
	Vector<Point> text = new Vector<Point>();
	Vector<String> text11 = new Vector<String>();
	Vector<String> select = new Vector<String>();
	Vector<String> linetype = new Vector<String>();
	Vector<Color> colorchois = new Vector<Color>();
	Point firstP = null;
	Point secondP = null;
	Point textP = null;
	Color color = Color.black;
	int click = 0;

	String chois = "사각형";
	String type = "윤각선";
	String data = "";

	boolean textcheck = false;
	boolean check = false;
	int stroke = 3;

	paint2() {

		addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		/*
		 * startP = e.getPoint(); endP = e.getPoint(); vs.add(startP);
		 * ve.add(endP); repaint();
		 */
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("마우스 버튼 누르고있음");

		if (textcheck) {
			textP = e.getPoint();
			text.addElement(textP);
			text11.addElement(data);
			//System.out.println(textP);
			textcheck = false;
			repaint();

		} else {

			if (click == 0) {
				firstP = e.getPoint();
				click++;
			} else if (click == 1) {
				secondP = e.getPoint();

				vf.add(firstP);
				vs.add(secondP);
				select.add(chois);
				linetype.add(type);
				colorchois.add(color);

				firstP = null;
				secondP = null;
				click = 0;
				check = true;
				repaint();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("마우스 버튼 때었음");

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, 0));

		g.setColor(color.black);  //글씨색은 검은색
		g.setFont(new Font("맑은고딕", Font.CENTER_BASELINE, 30));  //글씨크기와 폰트
		for (int i = 0; i < text.size(); i++) {
			Point x = text.elementAt(i);
			String t = text11.elementAt(i);
			g.drawString(t, (int) x.getX(), (int) x.getY());
		}

		textP = null;

		for (int i = 0; i < vs.size(); i++) {

			if (check) {

				Point s = vf.elementAt(i);
				Point e = vs.elementAt(i);
				String chois = select.elementAt(i);
				Color c = colorchois.elementAt(i);
				String t = linetype.elementAt(i);
				g.setColor(c);

				if (chois.equals("사각형")) {

					if (t.equals("윤각선")) {

						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // 오른쪽
																		// 아래
							g.drawRect((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY());
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 오른쪽 위
							g.drawRect((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()));
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 왼쪽위
							g.drawRect((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY());
						} else { // 왼쪽아래
							g.drawRect((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY());
						}

					} else if (t.equals("채우기")) {

						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // 오른쪽
																		// 아래
							g.fillRect((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY());
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 오른쪽 위
							g.fillRect((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()));
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 왼쪽위
							g.fillRect((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY());
						} else { // 왼쪽아래
							g.fillRect((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY());
						}

					}

				} else if (chois.equals("타원")) {

					if (t.equals("윤각선")) {
						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // 오른쪽
																		// 아래
							g.drawOval((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY());
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 오른쪽 위
							g.drawOval((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()));
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 왼쪽위
							g.drawOval((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY());
						} else { // 왼쪽아래
							g.drawOval((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY());
						}
					} else if (t.equals("채우기")) {
						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // 오른쪽
																		// 아래
							g.fillOval((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY());
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 오른쪽 위
							g.fillOval((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()));
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 왼쪽위
							g.fillOval((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY());
						} else { // 왼쪽아래
							g.fillOval((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY());
						}
					}
				} else if (chois.equals("둥근사각형")) {

					if (t.equals("윤각선")) {
						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // 오른쪽
																		// 아래
							g.drawRoundRect((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY(), 30, 30);
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 오른쪽 위
							g.drawRoundRect((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()),
									30, 30);
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 왼쪽위
							g.drawRoundRect((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY(), 30, 30);
						} else { // 왼쪽아래
							g.drawRoundRect((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY(), 30, 30);
						}
					} else if (t.equals("채우기")) {
						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // 오른쪽
																		// 아래
							g.fillRoundRect((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY(), 30, 30);
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 오른쪽 위
							g.fillRoundRect((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()),
									30, 30);
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // 왼쪽위
							g.fillRoundRect((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY(), 30, 30);
						} else { // 왼쪽아래
							g.fillRoundRect((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY(), 30, 30);
						}
					}

				} else if (chois.equals("직선")) {
					g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(),
							(int) e.getY());
				}

			}
		}

	}
}
