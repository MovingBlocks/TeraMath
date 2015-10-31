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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * A interactive test for {@link RectIterable}.
 * Use the main method to start.
 */
public final class InteractiveRectIterableTest {

    private static int cnt = 1;

    private InteractiveRectIterableTest() {
        // private
    }

    /**
     * @param args (ignored)
     */
    public static void main(String[] args) {
        // Create and set up the window.
        final JFrame frame = new JFrame("RectIterable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent comp = new JComponent() {
            private static final long serialVersionUID = -3019274194814342555L;

            @Override
            protected void paintComponent(final Graphics g1) {
                super.paintComponent(g1);
                final Graphics2D g = (Graphics2D) g1;
                int scale = 16;
                g.scale(scale, scale);

                BaseVector2i start = new Vector2i(3, 2);
                Rect2i rc = Rect2i.createFromMinAndSize(1, 2, 5, 4);
                RectIterable it = new RectIterable(rc, false, start);
                int ic = 0;

                ic = 0;
                g.setStroke(new BasicStroke(1f));
                for (BaseVector2i spt : it) {
                    Color c = Color.CYAN;
                    for (int i = 0; i < ic / (it.length()); i++) {
                        c = c.darker();
                    }
                    g.setColor(c);

                    g.draw(new Line2D.Double(spt.getX(), spt.getY(), spt.getX(), spt.getY()));

                    ic++;

                    if (ic == cnt) {
                        break;
                    }
                }

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

                g.setColor(Color.BLACK);
                g.setFont(g.getFont().deriveFont(3f));
                g.drawString("It : " + cnt, 2, 12);
            }
        };

        frame.add(comp);

        comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cnt++;
                e.getComponent().repaint();
            }
        });

        frame.setLocation(500, 200);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}