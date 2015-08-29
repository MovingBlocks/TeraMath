/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.math.geom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * A interactive test for {@link SpiralIterable}.
 * Use the main method to start.
 */
public final class InteractiveSpiralTest {


    private static Point pt;

    private static int cnt = 1;

    private InteractiveSpiralTest() {
        // private
    }

    /**
     * @param args (ignored)
     */
    public static void main(String[] args) {
        // Create and set up the window.
        final JFrame frame = new JFrame("Symmetry Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent comp = new JComponent() {
            private static final long serialVersionUID = -3019274194814342555L;

            @Override
            protected void paintComponent(final Graphics g1) {
                super.paintComponent(g1);
                final Graphics2D g = (Graphics2D) g1;
                int scale = 16;
                int centerX = getWidth() / (2 * scale);
                int centerY = getHeight() / (2 * scale);
                g.scale(scale, scale);

                if (pt != null) {
                    Vector2i mp = new Vector2i(pt.x / scale, pt.y / scale);

                    double mouseX = mp.getX();
                    double mouseY = mp.getY();

                    g.setColor(Color.CYAN);
                    g.draw(new Line2D.Double(mouseX, mouseY, mouseX, mouseY));
                }

                SpiralIterable it = SpiralIterable.counterClockwise(new Vector2i(centerX, centerY)).scale(2).build();
                SpiralIterable it1 = SpiralIterable.counterClockwise(new Vector2i(centerX, centerY)).scale(2).build();
                int ic = 0;

                Vector2i prev = new Vector2i(centerX, centerY);
                g.setColor(Color.BLACK);
                g.setStroke(new BasicStroke(0.2f));
                for (BaseVector2i spt : it1) {
                    g.draw(new Line2D.Double(prev.getX(), prev.getY(), spt.getX(), spt.getY()));
                    ic++;
                    prev.set(spt);
                    if (ic == cnt) {
                        break;
                    }
                }

                ic = 0;
                g.setColor(Color.BLUE);
                g.setStroke(new BasicStroke(1f));
                for (BaseVector2i spt : it) {
                    g.draw(new Line2D.Double(spt.getX(), spt.getY(), spt.getX(), spt.getY()));

                    ic++;
                    if (ic == cnt) {
                        break;
                    }
                }

                g.setColor(Color.BLACK);
                g.draw(new Line2D.Double(centerX, centerY, centerX, centerY));

                // draw grid
                g.translate(-0.5, -0.5);
                g.setStroke(new BasicStroke(0f));
                g.setColor(Color.LIGHT_GRAY);
                for (int i = 0; i < getWidth() / scale + 1; i++) {
                    g.drawLine(i, 0, i, getHeight());
                }
                for (int i = 0; i < getHeight() / scale + 1; i++) {
                    g.drawLine(0, i, getWidth(), i);
                }

                g.setStroke(new BasicStroke());
            }
        };

        frame.add(comp);

        comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                pt = null;
                e.getComponent().repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                cnt++;
                if (cnt == 100) {
                    cnt = 1;
                }
                e.getComponent().repaint();
            }
        });

        comp.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseMoved(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                pt = new Point(e.getX(), e.getY());
                e.getComponent().repaint();
            }

        });

        frame.setLocation(500, 200);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
