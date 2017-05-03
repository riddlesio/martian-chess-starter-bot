// Copyright 2015 theaigames.com (developers@theaigames.com)

//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at

//        http://www.apache.org/licenses/LICENSE-2.0

//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//	
//    For the full copyright and license information, please view the LICENSE
//    file that was distributed with this source code.

package bot;
/**
 * Field class
 * 
 * Field class that contains the field status data and various helper functions.
 * 
 * @author Jim van Eeden <jim@starapple.nl>, Joost <joost@starapple.nl>
 */

public class Field {

	private int myId;
	private int width;
	private int height;
	private String[][] field;

	public Field(int w, int h) {
		this.width = w;
		this.height = h;
		field = new String[w][h];
	}

	/**
	 * Initializes and clears field
	 * @throws Exception exception
	 */
	public void initField() throws Exception {
		try {
			this.field = new String[this.width][this.height];
		} catch (Exception e) {
			throw new Exception("Error: trying to initialize field while field "
					+ "settings have not been parsed yet.");
		}

		clearField();
	}

	/**
	 * Clears the field
	 */
	private void clearField() {
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				this.field[x][y] = ".";
			}
		}
	}

	/**
	 * Parse field from comma separated String
	 * @param s input from engine
	 */
	public void parseFromString(String s) {
		clearField();

		String[] split = s.split(",");
		int x = 0;
		int y = 0;

		for (String value : split) {
			this.field[x][y] = value;

			if (++x == this.width) {
				x = 0;
				y++;
			}
		}
	}

	public void setMyId(int id) {
		this.myId = id;
	}

	public void setWidth(int w) {
		this.width = w;
		field = new String[width][height];
	}

	public void setHeight(int h) {
		this.height = h;
		field = new String[width][height];
	}
}
