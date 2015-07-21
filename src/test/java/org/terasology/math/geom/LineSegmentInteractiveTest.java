/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.geom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 * Animated computation of line segment computations
 * @author Martin Steiger
 */
public final class LineSegmentInteractiveTest {

    protected static Vector2f cursor;

    private LineSegmentInteractiveTest() {

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        final JComponent panel = new JComponent() {

            private static final long serialVersionUID = 4178713176841691478L;

            @Override
            public void paint(Graphics g1) {
                super.paint(g1);

                Graphics2D g = (Graphics2D) g1;
                g.scale(2, 2);

                ImmutableVector2f p0 = new ImmutableVector2f(250, 70);
                ImmutableVector2f p1 = new ImmutableVector2f(160, 210);
                g.setColor(Color.BLUE);
                g.draw(new Line2D.Float(p0.getX(), p0.getY(), p1.getX(), p1.getY()));

                double thres = LineSegment.distanceToPoint(p0, p1, cursor);

                Rect2i bounds = Rect2i.createFromMinAndMax(0, 0, getWidth() / 2, getHeight() / 2);
                g.setColor(Color.BLACK);
                for (BaseVector2i l : bounds.contents()) {
                    double dist = LineSegment.distanceToPoint(p0, p1, new Vector2f(l.getX(), l.getY()));
                    if (dist > thres - 3 && dist < thres) {
                        g.drawLine(l.getX(), l.getY(), l.getX(), l.getY());
                    }
                }
            }
        };

        panel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {
                cursor = new Vector2f(e.getX() / 2, e.getY() / 2);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                cursor = new Vector2f(e.getX() / 2, e.getY() / 2);
            }
        });

        Timer timer = new Timer(100, new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });

        timer.start();
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(800 + 40, 2 * 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

