package com.mmall.core;

import java.util.*;

/**
 * @author ICe
 *
 */
public class Dicemojo {

	/**
	 * 翻译牌名 参数: 牌组
	 * 
	 * @return 牌名
	 */
	public static String getName(int i) {
		int flow = i % 10;
		int num = i / 10;
		String name = "";

		switch (flow) {
		case 0:
			break;
		case 1:
			name += "一";
			break;
		case 2:
			name += "二";
			break;
		case 3:
			name += "三";
			break;
		case 4:
			name += "四";
			break;
		case 5:
			name += "五";
			break;
		case 6:
			name += "六";
			break;
		case 7:
			name += "七";
			break;
		case 8:
			name += "八";
			break;
		case 9:
			name += "九";
			break;
		default:
			break;
		}

		switch (num) {
		case 1:
			name += "条";
			break;
		case 2:
			name += "筒";
			break;
		case 3:
			name += "万";
			break;
		case 5:
			name += "东风";
			break;
		case 6:
			name += "西风";
			break;
		case 7:
			name += "南风";
			break;
		case 8:
			name += "北风";
			break;
		case 9:
			name += "红中";
			break;
		case 10:
			name += "發财";
			break;
		case 11:
			name += "白板";
			break;
		default:
			break;
		}

		return name;
	}

	public static int[] allKinds = new int[] { 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29,
			31, 32, 33, 34, 35, 36, 37, 38, 39, 50, 60, 70, 80, 90, 100, 110 };
	public static int[] allKindsWhitOutChick = new int[] { 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27,
			28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 50, 60, 70, 80, 90, 100, 110 };
	public static int[] allKindsWhitOutWords = new int[] { 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26,
			27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39 };
	public static int[] allOldHeadKinds = new int[] { 50, 60, 70, 80, 90, 100, 110 };
	
	static int FiveTong = 25;
	static int SixTong = 26;
	static int Chick = 11;

	/**
	 * 创建一组完整的牌 参数: 无
	 * 
	 * @return 牌组
	 */
	public static int[] creatFullCards() {
		int[] temp = allKinds;
		int[] res = new int[temp.length * 4];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < 4; j++) {
				res[i * 4 + j] = temp[i];
			}
		}
		return res;
	}

	/**
	 * 创建一组完整的牌(无字) 参数: 无
	 * 
	 * @return 牌组
	 */
	public static int[] creatCardsWhitOutWords() {
		int[] temp = allKindsWhitOutWords;
		int[] res = new int[temp.length * 4];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < 4; j++) {
				res[i * 4 + j] = temp[i];
			}
		}
		return res;
	}

	/**
	 * 洗牌 参数: 牌组
	 * 
	 * @return 无
	 */
	public static void shuffle(int[] arr) {
		int temp = 0, index = 0;
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			index = ran.nextInt(arr.length);
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
	}
	
	/**
	 * 洗牌 参数: 牌组
	 * 
	 * @return 无
	 */
	public static void shufflePalyer(Object[] arr) {
		Object temp=null;
		int index = 0;
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			index = ran.nextInt(arr.length);
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
	}

	/**
	 * 排序 参数: 牌组
	 * 
	 * @return 无
	 */
	public static void sort(int[] numbers) {
		int temp; // 记录临时中间值
		int size = numbers.length; // 数组大小
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (numbers[i] > numbers[j]) { // 交换两数的位置
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}

	/**
	 * 统计出现过几种牌 参数: 牌组,调用前需要先排序
	 * 
	 * @return 数量
	 */
	public static int checkCount(int[] cards) {
		int total = 1;
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i] != cards[i + 1]) {
				total++;
			}
		}
		return total;
	}

	/**
	 * 判断是否是清一色 参数: 牌组,调用前需要先排序
	 * 
	 * @return 0不是;1,2,3,4代表是,并且是什么花色
	 */
	public static int checkOneColor(int[] cards) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] < 20) {
				count1++;
			} else if (cards[i] > 20 && cards[i] < 30) {
				count2++;
			} else if (cards[i] > 30 && cards[i] < 40) {
				count3++;
			} else if (cards[i] >= 40 && cards[i] <= 100) {
				count4++;
			}
		}
		if (count1 == cards.length) {
			return 1;
		}
		if (count2 == cards.length) {
			return 2;
		}
		if (count3 == cards.length) {
			return 3;
		}
		if (count4 == cards.length) {
			return 4;
		}
		return 0;
	}

	/**
	 * 统计牌组里的对子数 参数: 牌组,调用前需要先排序
	 * 
	 * @return 对子数量
	 */
	public static int checkPair(int[] cards) {
		int total = 0;
		// sort(cards);
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i] == cards[i + 1]) {
				total++;
			}
		}
		return total;
	}

	/**
	 * 获得除去对子后的牌组list 参数: 牌组,调用前需要先排序
	 * 
	 * @return 牌组list
	 */
	public static List<int[]> getCardsListWithoutPair(int[] cards) {
		List<int[]> res = new ArrayList<int[]>();
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i] == cards[i + 1]) {
				int[] temp = new int[cards.length - 2];
				int z = 0;
				for (int j = 0; j < cards.length; j++) {
					if (j != i && j != i + 1) {
						temp[z] = cards[j];
						z++;
					}
				}
				res.add(temp);
				if (i + 2<cards.length&&cards[i + 1]==cards[i + 2]) {
					i++;
					if (i + 3<cards.length&&cards[i + 2]==cards[i + 3]) {
						i++;
					} 
				} 
				
			}
		}
		return res;
	}

	/**
	 * 判断是否存在单身牌 参数: 牌组,调用前需要先排序
	 * 
	 * @return 单身牌数字;-1不存在;
	 */
	public static int checkSolo(int[] cards) {
		for (int i = 0; i < cards.length; i++) {
			int isBiger = 0;
			int isSmall = 0;
			int count = 0;
			for (int j = 0; j < cards.length; j++) {
				if (i != j && cards[i] == cards[j]) {// 检查是否重复
					count++;
					// System.out.println("发现重复");
				}
				if (cards[i] + 1 == cards[j]) {
					isSmall++;
					// System.out.println("发现小牵手");
				}
				if (cards[i] - 1 == cards[j]) {
					isBiger++;
					// System.out.println("发现大牵手");
				}
			}
			if (isSmall + isBiger + count == 0) {
				// System.out.println("单身牌检测未通过:"+intToString(cards));
				return cards[i];
			}
		}
		// System.out.println("单身牌检测通过,开始切割作业:"+intToString(cards));
		return -1;
	}

	/**
	 * 在牌组里找到同样的牌 参数: 牌组,调用前需要先排序;待查找的牌ID
	 * 
	 * @return 待查找的牌在牌组里的第一个位置,-1表示没有找到
	 */
	public static int findIndex(int[] cards, int toFind) {
		for (int i = 0; i < cards.length; i++) {
			if (toFind == cards[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 在牌组里找到同样的牌(两个) 参数: 牌组,调用前需要先排序;待查找的牌ID
	 * 
	 * @return 待查找的牌在牌组里的第一个位置,-1表示没有找到
	 */
	public static int findDubleIndex(int[] cards, int toFind) {
		int count = 0;
		for (int i = 0; i < cards.length; i++) {
			if (toFind == cards[i]) {
				count++;
			}
		}

		return count;
	}

	/**
	 * 切割牌组 参数: 牌组,调用前需要先排序;待查找的3个牌ID
	 * 
	 * @return 丢弃3个牌后的牌组
	 */
	public static int[] split(int[] cards, int index1, int index2, int index3) {
		int[] temp = new int[cards.length - 3];
		int z = 0;
		for (int j2 = 0; j2 < cards.length; j2++) {
			if (j2 != index1 && j2 != index2 && j2 != index3) {
				temp[z] = cards[j2];
				z++;
			}
		}
		return temp;
	}

	/**
	 * 递归按三张或者顺子切割 参数: 牌组,调用前需要先排序
	 * 
	 * @return 0至少有1个胡牌组合;1没有任何胡牌组合;
	 */
	public static int cutCards3By3(int[] cards) {
		if (cards.length <= 0) {
			// System.out.println("发现胡牌组合!!!");
			return 0;
		}

		if (checkSolo(cards) != -1) {
			return 1;
		}

		// 对每一个数进行检查
		for (int i = 0; i < cards.length-2; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (j + 1 < cards.length && cards[i] == cards[j] && cards[i] == cards[j + 1]) { // 开始是3张的时候
					// System.out.println("执行三张切割"+intToString(cards));
					if (cutCards3By3(split(cards, i, j, j + 1)) == 0) {
						return 0;
					}
				}

				int Small1 = findIndex(cards, cards[i] - 1);
				int Small2 = findIndex(cards, cards[i] - 2);
				int biger1 = findIndex(cards, cards[i] + 1);
				int biger2 = findIndex(cards, cards[i] + 2);
				if (biger1 != -1 && biger2 != -1) {
					// System.out.println("执行顺子切割: 后顺 "+intToString(cards));
					if (cutCards3By3(split(cards, i, biger1, biger2)) == 0) {
						return 0;
					}
				}
				if (Small1 != -1 && Small2 != -1) {
					// System.out.println("执行顺子切割: 前顺 "+intToString(cards));
					if (cutCards3By3(split(cards, Small2, Small1, i)) == 0) {
						return 0;
					}
				}
				if (Small1 != -1 && biger1 != -1) {
					// System.out.println("执行顺子切割: 中顺 "+intToString(cards));
					if (cutCards3By3(split(cards, Small1, i, biger1)) == 0) {
						return 0;
					}
				}
			}
		}

		return 1;
	}

	public static int getMaxScoer(int[] handCards, int[] underCards, int[] rmCards) {
		int[] AllCards = mixArr(handCards, underCards);
		AllCards = mixArr(AllCards, rmCards);
		sort(AllCards);
		int scoer = 0;
		if (checkWin(handCards) == 0) {
			// 普通小胡算1分
			scoer = 1;
			// 检查是否算大对
			int count = checkCount(AllCards);
			int[] solo=findNHand(AllCards, null, 1, true);
			
			if (count <= 5&&solo.length==0) {// 大对子
				scoer *= 2;
			}
			// 检查是否清一色
			if (checkOneColor(AllCards) > 0) {// 清一色
				scoer *= 2;
			}

		}
		return scoer;
	}
	
	public static int countTimes=0;
	public static Object[] getMaxScoerV2(int[] handCards, int[] underCards, int[] rmCards) {
		Object[] resObj=new Object[2];
		resObj[1]="";
		int[] AllCards = mixArr(handCards, underCards);
		AllCards = mixArr(AllCards, rmCards);
		sort(AllCards);
		int scoer = 0;
		if (checkWin(handCards) == 0) {
			// 普通小胡算1分
			scoer = 1;
			// 检查是否算大对
			int count = checkCount(AllCards);
			int[] solo=findNHand(AllCards, null, 1, true);
			
			if (count <= 5&&solo.length==0) {// 大对子
				int[] doublepair=findNHand(AllCards, null, 2, true);
				if (doublepair.length==1) {
					scoer *= 2;
					resObj[1]="大对";
				} 
			}
			// 检查是否清一色
			if (checkOneColor(AllCards) > 0) {// 清一色
				scoer *= 2;
				resObj[1]="清一色"+resObj[1];
			}

		}
		resObj[0]=scoer;
		return resObj;
	}
	
	
	public static Object[] getAllMaxScoerChickV2(int[] OrgInputHandCards, int[] inputUnderCards,int outCard, boolean isPeng, boolean isChick, boolean isLimit){
		Object[] resObj=new Object[2];
		
		int [] inputHandCards=addOne(OrgInputHandCards, outCard);
		sort(inputHandCards);
		

		
		if (isChick) {
			boolean isMax=false;
			if (isLimit&&count(inputHandCards, Chick)+count(inputUnderCards, Chick)==4) {
				resObj[0]=16;
				resObj[1]="四只小鸡";
				//4只鸡直接16分
				return resObj;
			}
			int theoryMaxSocer=8;
			int [] CardsRemoveChick=Dicemojo.remove(inputHandCards, Chick);
			if (checkCount(CardsRemoveChick)<=(5-(inputUnderCards.length/3))) {//理论大对可能性
				theoryMaxSocer*=2;
			} 
			
			if (isPeng==false&&inputHandCards.length==14&&checkCount(CardsRemoveChick)<=5) {//理论两龙七对可能性
				theoryMaxSocer=16;
				if (checkCount(CardsRemoveChick)<=4) {
					theoryMaxSocer=32;
				} 
			} 
			
			if (checkOneColor(mixArr(CardsRemoveChick,inputUnderCards))>0) {//理论清一色可能性
				theoryMaxSocer*=2;
			} 
			
			
			int orginNum = count(inputHandCards, Chick);
			int[] handCards=Dicemojo.mixArr(inputHandCards,null);
			int[] underCards=Dicemojo.mixArr(inputUnderCards,null);
			if (isPeng&&outCard!=0) {
				int[][] temp=Dicemojo.underSwapChick(inputHandCards, inputUnderCards, outCard,isChick);
				handCards=temp[0];
				underCards=temp[1];
			}
			int num=count(handCards, Chick);
			if (num > 0 && num <= 4) {
				int[] cardsTemp = mixArr(handCards, null);
				List<Object[]> Scoer=new ArrayList<Object[]>();
				cardsTemp = removeN(cardsTemp, Chick, 1);
				for (int i = 0; i < allKindsWhitOutChick.length; i++) {
					int[] cardsTemp0 = mixArr(cardsTemp, null);
					cardsTemp0 = mixArr(cardsTemp0, new int[] { allKindsWhitOutChick[i] });
				
					int num1 = count(cardsTemp0, Chick);
					if (num1>0) {
						cardsTemp0 = removeN(cardsTemp0, Chick, 1);
						for (int i1 = 0; i1 < allKindsWhitOutChick.length; i1++) {
							int[] cardsTemp1 = mixArr(cardsTemp0, null);
							cardsTemp1 = mixArr(cardsTemp1, new int[] { allKindsWhitOutChick[i1] });

							int num2 = count(cardsTemp1, Chick);
							if (num2 > 0) {
								cardsTemp1 = removeN(cardsTemp1, Chick, 1);
								for (int i2 = 0; i2 < allKindsWhitOutChick.length; i2++) {
									int[] cardsTemp2 = mixArr(cardsTemp1, null);
									cardsTemp2 = mixArr(cardsTemp2, new int[] { allKindsWhitOutChick[i2] });
									
									int num3 = count(cardsTemp2, Chick);
									if (num3 > 0) {
										cardsTemp2 = removeN(cardsTemp2, Chick, 1);
										for (int i3 = 0; i3 < allKindsWhitOutChick.length; i3++) {
											if (isMax==true) {
												break;
											}
											
											int[] cardsTemp3 = mixArr(cardsTemp2, null);
											cardsTemp3 = mixArr(cardsTemp3, new int[] { allKindsWhitOutChick[i3] });
											Object[] ScoerTemp3=getAllMaxScoerV2(cardsTemp3, underCards,isPeng);
											if ((int)ScoerTemp3[0]==theoryMaxSocer) {
												isMax=true;
											}
											Scoer.add(filterScoerV2(ScoerTemp3,orginNum,isLimit));
										}
									}else {
										if (isMax==true) {
											break;
										}
										Object[] ScoerTemp2=getAllMaxScoerV2(cardsTemp2, underCards,isPeng);
										if ((int)ScoerTemp2[0]==theoryMaxSocer) {
											isMax=true;
										}
										Scoer.add(filterScoerV2(ScoerTemp2,orginNum,isLimit));
									}
								}
							}else {
								if (isMax==true) {
									break;
								}
								Object[] ScoerTemp1=getAllMaxScoerV2(cardsTemp1, underCards,isPeng);
								if ((int)ScoerTemp1[0]==theoryMaxSocer) {
									isMax=true;
								}
								Scoer.add(filterScoerV2(ScoerTemp1,orginNum,isLimit));
							}
						}
					} else {
						if (isMax==true) {
							break;
						}
						Object[] ScoerTemp0=getAllMaxScoerV2(cardsTemp0, underCards,isPeng);
						if ((int)ScoerTemp0[0]==theoryMaxSocer) {
							isMax=true;
						}
						Scoer.add(filterScoerV2(ScoerTemp0,orginNum,isLimit));
					}
				}
				

				Object[] ScoerSta=filterScoerV2(getAllMaxScoerV2(handCards, underCards,isPeng),orginNum,isLimit); 
				Scoer.add(ScoerSta);
				Object[] scoer = new Object[]{0,""};
				//System.out.println(Scoer.size());
				for (int i = 0; i < Scoer.size(); i++) {
					if ( (int)scoer[0] < (int)Scoer.get(i)[0]) {
						scoer = Scoer.get(i);
					}
				}
				return scoer;
			}else {
				Object[] scoer=filterScoerV2(getAllMaxScoerV2(handCards, underCards,isPeng),orginNum,isLimit);
				if (orginNum>0) {
					return scoer;
				}
				//没有鸡直接返回双倍
				scoer[0]=(int)scoer[0]*2;
				scoer[1]="硬"+(String)scoer[1];
				return scoer;
			}
		}else {
			return getAllMaxScoerV2(inputHandCards, inputUnderCards,isPeng);
		}
	}
	
	public static int getAllMaxScoerChick(int[] OrgInputHandCards, int[] inputUnderCards, int outCard, boolean isPeng,
			boolean isChick, boolean isLimit) {
		int[] inputHandCards = addOne(OrgInputHandCards, outCard);
		sort(inputHandCards);

		if (isChick) {

			if (isLimit && count(inputHandCards, Chick) + count(inputUnderCards, Chick) == 4) {
				// 4只鸡直接16分
				return 16;
			}
			int orginNum = count(inputHandCards, Chick);
			int[] handCards = Dicemojo.mixArr(inputHandCards, null);
			int[] underCards = Dicemojo.mixArr(inputUnderCards, null);
			if (isPeng && outCard != 0) {
				int[][] temp = Dicemojo.underSwapChick(inputHandCards, inputUnderCards, outCard, isChick);
				handCards = temp[0];
				underCards = temp[1];
			}
			int num = count(handCards, Chick);
			if (num > 0 && num <= 4) {
				int[] cardsTemp = mixArr(handCards, null);
				List<Integer> Scoer = new ArrayList<Integer>();
				cardsTemp = removeN(cardsTemp, Chick, 1);
				for (int i = 0; i < allKindsWhitOutChick.length; i++) {
					int[] cardsTemp0 = mixArr(cardsTemp, null);
					cardsTemp0 = mixArr(cardsTemp0, new int[] { allKindsWhitOutChick[i] });
					int ScoerTemp0 = getAllMaxScoer(cardsTemp0, underCards, isPeng);
					Scoer.add(filterScoer(ScoerTemp0, orginNum, isLimit));
					int num1 = count(cardsTemp0, Chick);
					if (num1 > 0) {
						cardsTemp0 = removeN(cardsTemp0, Chick, 1);
						for (int i1 = 0; i1 < allKindsWhitOutChick.length; i1++) {
							int[] cardsTemp1 = mixArr(cardsTemp0, null);
							cardsTemp1 = mixArr(cardsTemp1, new int[] { allKindsWhitOutChick[i1] });

							int ScoerTemp1 = getAllMaxScoer(cardsTemp1, underCards, isPeng);
							Scoer.add(filterScoer(ScoerTemp1, orginNum, isLimit));

							int num2 = count(cardsTemp1, Chick);
							if (num2 > 0) {
								cardsTemp1 = removeN(cardsTemp1, Chick, 1);
								for (int i2 = 0; i2 < allKindsWhitOutChick.length; i2++) {
									int[] cardsTemp2 = mixArr(cardsTemp1, null);
									cardsTemp2 = mixArr(cardsTemp2, new int[] { allKindsWhitOutChick[i2] });
									int ScoerTemp2 = getAllMaxScoer(cardsTemp2, underCards, isPeng);
									Scoer.add(filterScoer(ScoerTemp2, orginNum, isLimit));

									int num3 = count(cardsTemp2, Chick);
									if (num3 > 0) {
										cardsTemp2 = removeN(cardsTemp2, Chick, 1);
										for (int i3 = 0; i3 < allKindsWhitOutChick.length; i3++) {
											int[] cardsTemp3 = mixArr(cardsTemp2, null);
											cardsTemp3 = mixArr(cardsTemp3, new int[] { allKindsWhitOutChick[i3] });
											int ScoerTemp3 = getAllMaxScoer(cardsTemp3, underCards, isPeng);
											Scoer.add(filterScoer(ScoerTemp3, orginNum, isLimit));
										}
									}
								}
							}
						}
					}
				}

				int ScoerSta = filterScoer(getAllMaxScoer(handCards, underCards, isPeng), orginNum, isLimit);
				Scoer.add(ScoerSta);
				int scoer = 0;
				for (int i = 0; i < Scoer.size(); i++) {
					if (scoer < Scoer.get(i)) {
						scoer = Scoer.get(i);
					}
				}
				return scoer;
			} else {
				if (orginNum > 0) {
					return filterScoer(getAllMaxScoer(handCards, underCards, isPeng), orginNum, isLimit);
				}
				// 没有鸡直接返回双倍
				return 2 * filterScoer(getAllMaxScoer(handCards, underCards, isPeng), orginNum, isLimit);
			}
		} else {
			return getAllMaxScoer(inputHandCards, inputUnderCards, isPeng);
		}
	}
	
	
	//根据鸡的数量 排除分数小的
	private static int filterScoer(int Scoer,int num,boolean isLimit){
		if (isLimit) {
			int res=0;
			switch (num) {
			case 0:
				res=Scoer;
				break;
			case 1:
				if (Scoer>=4) {
					res=Scoer;
				}
				break;
			case 2:
				if (Scoer>=8) {
					res=Scoer;
				}
				break;
			case 3:
				if (Scoer>=8) {
					res=Scoer;
				}
				break;
			case 4:
				res=16;
				break;

			default:
				break;
			}
			return res;
		}else {
			return Scoer;
		}
	}
	
	//根据鸡的数量 排除分数小的
	private static Object[] filterScoerV2(Object[] Scoer,int num,boolean isLimit){
		if (isLimit) {
			int res=0;
			switch (num) {
			case 0:
				res=(int) Scoer[0];
				break;
			case 1:
				if ((int) Scoer[0]>=4) {
					res=(int) Scoer[0];
				}
				break;
			case 2:
				if ((int) Scoer[0]>=8) {
					res=(int) Scoer[0];
				}
				break;
			case 3:
				if ((int) Scoer[0]>=8) {
					res=(int) Scoer[0];
				}
				break;
			case 4:
				res=16;
				break;

			default:
				break;
			}
			Scoer[0]=res;
			return Scoer;
		}else {
			return Scoer;
		}
	}
	
	/**
	 * 统计牌型最大得分 参数: 牌组,调用前需要先排序
	 * 
	 * @return 得分;
	 */
	public static int getAllMaxScoer(int[] handCards, int[] underCards,boolean isPeng) {
		int scoer = 1;
		sort(handCards);
		int[] dragons = findDragon(handCards, underCards);
		List<Integer> scoerList = new ArrayList<>();

		if (dragons.length > 0) {// 两龙的情况 替换两张
			if (dragons.length == 3) {
				for (int index = 0; index < dragons.length; index++) {
					int[] temp = new int[handCards.length];
					int[] rmTemp = new int[] {};
					for (int j = 0; j < handCards.length; j++) {
						temp[j] = handCards[j];
					}
					int indexNext = index + 1;
					if (indexNext == 3) {
						indexNext = 0;
					}

					int handDragon0 = temp[dragons[index]];
					int handDragon1 = temp[dragons[indexNext]];
					if (dragons[index] + 1 < temp.length && temp[dragons[index] + 1] == handDragon0) {
						temp[dragons[index]] = FiveTong;
						temp = replaceN(temp, temp[dragons[index] + 1], -1, 3);
						rmTemp = mixArr(rmTemp, new int[] { handDragon0, handDragon0, handDragon0 });
					} else {
						temp[dragons[index]] = FiveTong;
					}
					if (dragons[indexNext] + 1 < temp.length && temp[dragons[indexNext] + 1] == handDragon1) {
						temp[dragons[indexNext]] = SixTong;
						temp = replaceN(temp, temp[dragons[indexNext] + 1], -1, 3);
						rmTemp = mixArr(rmTemp, new int[] { handDragon1, handDragon1, handDragon1 });
					} else {
						temp[dragons[indexNext]] = SixTong;
					}
					temp = remove(temp, -1);
					sort(temp);
					scoerList.add(8 * getMaxScoer(temp, underCards, rmTemp));

				}
			}
			if (dragons.length == 2) {
				int[] temp = new int[handCards.length];
				int[] rmTemp = new int[] {};
				for (int j = 0; j < handCards.length; j++) {
					temp[j] = handCards[j];
				}
				int handDragon0 = temp[dragons[0]];
				int handDragon1 = temp[dragons[1]];
				if (dragons[0] + 1 < temp.length && temp[dragons[0] + 1] == handDragon0) {
					temp[dragons[0]] = FiveTong;
					temp = replaceN(temp, temp[dragons[0] + 1], -1, 3);
					rmTemp = mixArr(rmTemp, new int[] { handDragon0, handDragon0, handDragon0 });
				} else {
					temp[dragons[0]] = FiveTong;
				}
				if (dragons[1] + 1 < temp.length && temp[dragons[1] + 1] == handDragon1) {
					temp[dragons[1]] = SixTong;
					temp = replaceN(temp, temp[dragons[1] + 1], -1, 3);
					rmTemp = mixArr(rmTemp, new int[] { handDragon1, handDragon1, handDragon1 });
				} else {
					temp[dragons[1]] = SixTong;
				}
				temp = remove(temp, -1);
				sort(temp);
				scoerList.add(8 * getMaxScoer(temp, underCards, rmTemp));
			}

			for (int index = 0; index < dragons.length; index++) {
				int[] temp5 = new int[handCards.length];
				int[] tempUnder5 = new int[underCards.length];
				int[] rmTemp5 = new int[] {};
				for (int j = 0; j < handCards.length; j++) {
					temp5[j] = handCards[j];
				}
				for (int j = 0; j < underCards.length; j++) {
					tempUnder5[j] = underCards[j];
				}
				int handDragon5 = temp5[dragons[index]];
				if (dragons[index] + 1 < temp5.length && temp5[dragons[index] + 1] == handDragon5) {
					temp5[dragons[index]] = FiveTong;
					temp5 = removeN(temp5, temp5[dragons[index] + 1], 3);
					rmTemp5 = mixArr(rmTemp5, new int[] { handDragon5, handDragon5, handDragon5 });
				} else {
					tempUnder5=removeN(tempUnder5, temp5[dragons[index]], 3);
					temp5[dragons[index]] = FiveTong;
				}

				sort(temp5);
				int[] dragons5 = findDragon(temp5, tempUnder5);
				if (dragons5.length > 0) {
					for (int index5 = 0; index5 < dragons5.length; index5++) {
						int[] temp56 = new int[temp5.length];
						for (int j = 0; j < temp5.length; j++) {
							temp56[j] = temp5[j];
						}
						int handDragon56 = temp56[dragons5[index5]];
						if (dragons5[index5] + 1 < temp56.length && temp56[dragons5[index5] + 1] == handDragon56) {
							temp56[dragons5[index5]] = SixTong;
							temp56 = removeN(temp56, temp56[dragons5[index5] + 1], 3);
							rmTemp5 = mixArr(rmTemp5, new int[] { handDragon56, handDragon56, handDragon56 });
						} else {
							temp56[dragons5[index5]] = SixTong;
						}
						sort(temp56);
						scoerList.add(8 * getMaxScoer(temp56, underCards, rmTemp5));
					}
					scoerList.add(4 * getMaxScoer(temp5, underCards, rmTemp5));
				} else if (dragons5.length == 0) {
					scoerList.add(4 * getMaxScoer(temp5, underCards, rmTemp5));
				}

				int[] rmTemp6 = new int[] {};
				int[] temp6 = new int[handCards.length];
				int[] tempUnder6 = new int[underCards.length];
				for (int j = 0; j < handCards.length; j++) {
					temp6[j] = handCards[j];
				}
				for (int j = 0; j < underCards.length; j++) {
					tempUnder6[j] = underCards[j];
				}
				int handDragon6 = temp6[dragons[index]];
				if (dragons[index] + 1 < temp6.length && temp6[dragons[index] + 1] == handDragon6) {
					temp6[dragons[index]] = SixTong;
					temp6 = removeN(temp6, temp6[dragons[index] + 1], 3);
					rmTemp6 = mixArr(rmTemp6, new int[] { handDragon6, handDragon6, handDragon6 });
				} else {
					tempUnder6=removeN(tempUnder6, temp6[dragons[index]], 3);
					temp6[dragons[index]] = SixTong;
				}
				sort(temp6);
				int[] dragons6 = findDragon(temp6, tempUnder6);
				if (dragons6.length > 0) {
					for (int index6 = 0; index6 < dragons6.length; index6++) {
						int[] temp65 = new int[temp6.length];
						for (int j = 0; j < temp6.length; j++) {
							temp65[j] = temp6[j];
						}
						int handDragon65 = temp65[dragons6[index6]];
						if (dragons6[index6] + 1 < temp65.length && temp65[dragons6[index6] + 1] == handDragon65) {
							temp65[dragons6[index6]] = FiveTong;
							temp65 = removeN(temp65, temp65[dragons6[index6] + 1], 3);
							rmTemp6 = mixArr(rmTemp6, new int[] { handDragon65, handDragon65, handDragon65 });
						} else {
							temp65[dragons6[index6]] = FiveTong;
						}
						sort(temp65);
						scoerList.add(8 * getMaxScoer(temp65, underCards, rmTemp6));
					}
					scoerList.add(2 * getMaxScoer(temp6, underCards, rmTemp6));
				} else if (dragons6.length == 0) {
					scoerList.add(2 * getMaxScoer(temp6, underCards, rmTemp6));
				}

			}

		}
		if (isPeng==false) {//自摸才可以胡小胡和龙七对
			scoerList.add(getMaxScoer(handCards, underCards, null));
			// 判断是否是龙七对
			int sevenpair = 0;
			switch (checkWinOf7Pair(handCards)) {
			case 0:
				sevenpair = 4;
				break;
			case 1:
				sevenpair = 8;
				break;
			case 2:
				sevenpair = 16;
				break;
			case 3:
				sevenpair = 32;
				break;

			default:
				break;
			}
			if (checkOneColor(mixArr(handCards, underCards)) > 0) {// 清一色
				sevenpair *= 2;
			}
			scoerList.add(sevenpair);
		}

		
		
		scoer = 0;
		for (int i = 0; i < scoerList.size(); i++) {
			if (scoer < scoerList.get(i)) {
				scoer = scoerList.get(i);
			}
		}

		return scoer;

	}
	
	/**
	 * 统计牌型最大得分 参数: 牌组,调用前需要先排序
	 * 
	 * @return 得分;
	 */
	public static Object[] getAllMaxScoerV2(int[] handCards, int[] underCards,boolean isPeng) {
		Object[] scoer = new Object[2];
		sort(handCards);
		int[] dragons = findDragon(handCards, underCards);
		
		List<Object[]> scoerList = new ArrayList<Object[]>();

		if (dragons.length > 0) {// 两龙的情况 替换两张
			if (dragons.length == 3) {
				for (int index = 0; index < dragons.length; index++) {
					int[] temp = new int[handCards.length];
					int[] rmTemp = new int[] {};
					for (int j = 0; j < handCards.length; j++) {
						temp[j] = handCards[j];
					}
					int indexNext = index + 1;
					if (indexNext == 3) {
						indexNext = 0;
					}

					int handDragon0 = temp[dragons[index]];
					int handDragon1 = temp[dragons[indexNext]];
					if (dragons[index] + 1 < temp.length && temp[dragons[index] + 1] == handDragon0) {
						temp[dragons[index]] = FiveTong;
						temp = replaceN(temp, temp[dragons[index] + 1], -1, 3);
						rmTemp = mixArr(rmTemp, new int[] { handDragon0, handDragon0, handDragon0 });
					} else {
						temp[dragons[index]] = FiveTong;
					}
					if (dragons[indexNext] + 1 < temp.length && temp[dragons[indexNext] + 1] == handDragon1) {
						temp[dragons[indexNext]] = SixTong;
						temp = replaceN(temp, temp[dragons[indexNext] + 1], -1, 3);
						rmTemp = mixArr(rmTemp, new int[] { handDragon1, handDragon1, handDragon1 });
					} else {
						temp[dragons[indexNext]] = SixTong;
					}
					temp = remove(temp, -1);
					sort(temp);
					Object[] scoerTemp = getMaxScoerV2(temp, underCards, rmTemp);
					scoerTemp[0]=8*(int)scoerTemp[0];
					scoerTemp[1]=scoerTemp[1]+"双抬";
					scoerList.add(scoerTemp);

				}
			}
			if (dragons.length == 2) {
				int[] temp = new int[handCards.length];
				int[] rmTemp = new int[] {};
				for (int j = 0; j < handCards.length; j++) {
					temp[j] = handCards[j];
				}
				int handDragon0 = temp[dragons[0]];
				int handDragon1 = temp[dragons[1]];
				if (dragons[0] + 1 < temp.length && temp[dragons[0] + 1] == handDragon0) {
					temp[dragons[0]] = FiveTong;
					temp = replaceN(temp, temp[dragons[0] + 1], -1, 3);
					rmTemp = mixArr(rmTemp, new int[] { handDragon0, handDragon0, handDragon0 });
				} else {
					temp[dragons[0]] = FiveTong;
				}
				if (dragons[1] + 1 < temp.length && temp[dragons[1] + 1] == handDragon1) {
					temp[dragons[1]] = SixTong;
					temp = replaceN(temp, temp[dragons[1] + 1], -1, 3);
					rmTemp = mixArr(rmTemp, new int[] { handDragon1, handDragon1, handDragon1 });
				} else {
					temp[dragons[1]] = SixTong;
				}
				temp = remove(temp, -1);
				sort(temp);
				Object[] scoerTemp = getMaxScoerV2(temp, underCards, rmTemp);
				scoerTemp[0]=8*(int)scoerTemp[0];
				scoerTemp[1]=scoerTemp[1]+"双抬";
				scoerList.add(scoerTemp);
			}

			for (int index = 0; index < dragons.length; index++) {
				int[] temp5 = new int[handCards.length];
				int[] tempUnder5 = new int[underCards.length];
				int[] rmTemp5 = new int[] {};
				for (int j = 0; j < handCards.length; j++) {
					temp5[j] = handCards[j];
				}
				for (int j = 0; j < underCards.length; j++) {
					tempUnder5[j] = underCards[j];
				}
				int handDragon5 = temp5[dragons[index]];
				if (dragons[index] + 3 < temp5.length && temp5[dragons[index] + 3] == handDragon5) {
					temp5[dragons[index]] = FiveTong;
					temp5 = removeN(temp5, temp5[dragons[index] + 1], 3);
					rmTemp5 = mixArr(rmTemp5, new int[] { handDragon5, handDragon5, handDragon5 });
				} else {
					tempUnder5=removeN(tempUnder5, temp5[dragons[index]], 3);
					temp5[dragons[index]] = FiveTong;
				}

				sort(temp5);
				int[] dragons5 = findDragon(temp5, tempUnder5);
				if (dragons5.length > 0) {
					for (int index5 = 0; index5 < dragons5.length; index5++) {
						int[] temp56 = new int[temp5.length];
						for (int j = 0; j < temp5.length; j++) {
							temp56[j] = temp5[j];
						}
						int handDragon56 = temp56[dragons5[index5]];
						if (dragons5[index5] + 3 < temp56.length && temp56[dragons5[index5] + 3] == handDragon56) {
							temp56[dragons5[index5]] = SixTong;
							temp56 = removeN(temp56, temp56[dragons5[index5] + 1], 3);
							rmTemp5 = mixArr(rmTemp5, new int[] { handDragon56, handDragon56, handDragon56 });
						} else {
							temp56[dragons5[index5]] = SixTong;
						}
						sort(temp56);
						Object[] scoerTemp = getMaxScoerV2(temp56, underCards, rmTemp5);
						scoerTemp[0]=8*(int)scoerTemp[0];
						scoerTemp[1]=scoerTemp[1]+"双抬";
						scoerList.add(scoerTemp);
					}
					Object[] scoerTemp = getMaxScoerV2(temp5, underCards, rmTemp5);
					scoerTemp[0]=4*(int)scoerTemp[0];
					scoerTemp[1]=scoerTemp[1]+"五梅花";
					scoerList.add(scoerTemp);
				} else if (dragons5.length == 0) {
					Object[] scoerTemp = getMaxScoerV2(temp5, underCards, rmTemp5);
					scoerTemp[0]=4*(int)scoerTemp[0];
					scoerTemp[1]=scoerTemp[1]+"五梅花";
					scoerList.add(scoerTemp);
				}

				int[] rmTemp6 = new int[] {};
				int[] temp6 = new int[handCards.length];
				int[] tempUnder6 = new int[underCards.length];
				for (int j = 0; j < handCards.length; j++) {
					temp6[j] = handCards[j];
				}
				for (int j = 0; j < underCards.length; j++) {
					tempUnder6[j] = underCards[j];
				}
				int handDragon6 = temp6[dragons[index]];
				if (dragons[index] + 3< temp6.length && temp6[dragons[index] + 3] == handDragon6) {
					temp6[dragons[index]] = SixTong;
					temp6 = removeN(temp6, temp6[dragons[index] + 1], 3);
					rmTemp6 = mixArr(rmTemp6, new int[] { handDragon6, handDragon6, handDragon6 });
				} else {
					tempUnder6=removeN(tempUnder6, temp6[dragons[index]], 3);
					temp6[dragons[index]] = SixTong;
				}
				sort(temp6);
				int[] dragons6 = findDragon(temp6, tempUnder6);
				if (dragons6.length > 0) {
					for (int index6 = 0; index6 < dragons6.length; index6++) {
						int[] temp65 = new int[temp6.length];
						for (int j = 0; j < temp6.length; j++) {
							temp65[j] = temp6[j];
						}
						int handDragon65 = temp65[dragons6[index6]];
						if (dragons6[index6] + 3 < temp65.length && temp65[dragons6[index6] + 3] == handDragon65) {
							temp65[dragons6[index6]] = FiveTong;
							temp65 = removeN(temp65, temp65[dragons6[index6] + 1], 3);
							rmTemp6 = mixArr(rmTemp6, new int[] { handDragon65, handDragon65, handDragon65 });
						} else {
							temp65[dragons6[index6]] = FiveTong;
						}
						sort(temp65);
						Object[] scoerTemp = getMaxScoerV2(temp65, underCards, rmTemp6);
						scoerTemp[0]=8*(int)scoerTemp[0];
						scoerTemp[1]=scoerTemp[1]+"双抬";
						scoerList.add(scoerTemp);
					}
					Object[] scoerTemp = getMaxScoerV2(temp6, underCards, rmTemp6);
					scoerTemp[0]=2*(int)scoerTemp[0];
					scoerTemp[1]=scoerTemp[1]+"六筒";
					scoerList.add(scoerTemp);
				} else if (dragons6.length == 0) {
					Object[] scoerTemp =  getMaxScoerV2(temp6, underCards, rmTemp6);
					scoerTemp[0]=2*(int)scoerTemp[0];
					scoerTemp[1]=scoerTemp[1]+"六筒";
					scoerList.add(scoerTemp);
				}

			}

		}
		if (isPeng==false) {//自摸才可以胡小胡和龙七对
			boolean isHua=false;
			//没有花再计算小胡
			for (int i = 0; i < scoerList.size(); i++) {
				if ((int)scoerList.get(i)[0]>0){
					isHua=true;
					break;
				}
			}
			if (isHua==false) {
				scoerList.add(getMaxScoerV2(handCards, underCards, null));
			}
			// 判断是否是龙七对
			if (handCards.length==14) {
				Object[] scoerTemp =new Object[2];
				scoerTemp[1]="";
				int sevenpair = 0;
				switch (checkWinOf7Pair(handCards)) {
				case 0:
					sevenpair = 4;
					scoerTemp[1]="小七对";
					break;
				case 1:
					sevenpair = 8;
					scoerTemp[1]="龙七对";
					break;
				case 2:
					sevenpair = 16;
					scoerTemp[1]="双龙七对";
					break;
				case 3:
					sevenpair = 32;
					scoerTemp[1]="三龙七对";
					break;

				default:
					break;
				}
				if (checkOneColor(mixArr(handCards, underCards)) > 0) {// 清一色
					sevenpair *= 2;
					scoerTemp[1]="清一色"+scoerTemp[1];
				}
				scoerTemp[0]=sevenpair;
				scoerList.add(scoerTemp);
			} 
			
		}

		
		
		scoer[0] = 0;
		scoer[1] = "";
		for (int i = 0; i < scoerList.size(); i++) {
			if ((int)scoer[0] < (int)scoerList.get(i)[0]) {
				scoer = scoerList.get(i);
			}
		}
		if (scoer[1].toString().length()==0) {
			scoer[1]="小胡";
		}
		return scoer;

	}

	/**
	 * 判断是否胡牌 参数: 牌组,调用前需要先排序
	 * 
	 * @return 0胡牌;1不胡牌(没有对子);2不胡牌(组合不出)
	 */
	public static int checkWin(int[] cards) {
		countTimes++;
		// System.out.println("检查的对象:" + intToString(cards));
		List<int[]> listWithoutPair = getCardsListWithoutPair(cards);
		int pairs = listWithoutPair.size();
		// System.out.println("移除对子后的结果数:" + pairs);

		if (pairs == 0) {
			return 1;// 没有对子
		} else {
			for (int i = 0; i < listWithoutPair.size(); i++) {
				// System.out.println((i + 1) + "/" + pairs + ":" +
				// intToString(listWithoutPair.get(i)));
				if (cutCards3By3(listWithoutPair.get(i)) == 0) {
					return 0;// 返回0代表胡牌
				}
			}
			return 2;// 有对子但是不胡牌
		}
	}

	/**
	 * 判断是否胡牌(小七对) 参数: 牌组,调用前需要先排序
	 * 
	 * @return -1不胡牌;0小七对，1龙七对，2双龙七对，3三龙七对
	 */
	public static int checkWinOf7Pair(int[] cards) {
		int[] pairs = findNHand(cards, null, 2, true);
		int[] dragons = findNHand(cards, null, 4, true);
		if (pairs.length == 7) {
			return 0;
		}
		if (pairs.length == 5 && dragons.length == 1) {
			return 1;
		}
		if (pairs.length == 3 && dragons.length == 2) {
			return 2;
		}
		if (pairs.length == 1 && dragons.length == 3) {
			return 3;
		}

		return -1;
	}

	/**
	 * 找到所有听牌 参数: 牌组,调用前需要先排序
	 * 
	 * @param removeCard
	 * @return 所有听牌序列
	 */
	public static int[] findListen(int[] cards, int[] kinds, int[] removeCard, int[] underCards) {

		List<Integer> allListen = new ArrayList<Integer>();
		// 牌组和所有类型组合成新牌组
		for (int i = 0; i < kinds.length; i++) {
			int[] temp = new int[cards.length + 1];
			for (int j = 0; j < cards.length; j++) {
				temp[j] = cards[j];
			}
			temp[cards.length] = kinds[i];
			sort(temp);
			if (checkWin(temp) == 0) {
				// 检查是否存在5张56筒的情况
				if (check5Cards(temp, removeCard, underCards) == 0) {
					allListen.add(kinds[i]);
				}
			}
		}

		return intListToIntArr(allListen);
	}

	/**
	 * 找到所有听牌(小七对) 参数: 牌组,调用前需要先排序
	 * 
	 * @return 所有听牌序列
	 */
	public static int[] findListenOf7Pair(int[] cards, int[] kinds) {

		List<Integer> allListen = new ArrayList<Integer>();
		// 牌组和所有类型组合成新牌组
		for (int i = 0; i < kinds.length; i++) {
			int[] temp = new int[cards.length + 1];
			for (int j = 0; j < cards.length; j++) {
				temp[j] = cards[j];
			}
			temp[cards.length] = kinds[i];
			sort(temp);
			if (checkWinOf7Pair(temp) >= 0) {
				allListen.add(kinds[i]);
			}
		}

		return intListToIntArr(allListen);
	}

	// 检查是否有5只牌的情况
	private static int check5Cards(int[] handCards, int[] removeCard, int[] underCards) {
		int[] newCards = mixArr(handCards, removeCard);
		newCards = mixArr(handCards, underCards);
		sort(newCards);
		for (int i = 0; i < newCards.length; i++) {
			int count = 0;
			for (int j = i; j < newCards.length; j++) {
				if (newCards[i] == newCards[j]) {
					count++;
				}
			}
			if (count == 5) {
				if (newCards[i] != FiveTong && newCards[i] != SixTong) {
					return 1;
				}
			}
		}
		return 0;
	}

	public static int[] intListToIntArr(List<Integer> list) {
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	// 小鸡飞听牌计算
	public static int[] getAllListen(int[] handCards, int[] underCards, int[] kinds, boolean isSelf, boolean isChick) {
		if (isChick) {
			int num = count(handCards, Chick);
			if (num > 0 && num < 4) {
				int[] cardsTemp = mixArr(handCards, null);
				int[] res = new int[] {};
				cardsTemp = removeN(cardsTemp, Chick, 1);
				for (int i = 0; i < allKindsWhitOutChick.length; i++) {
					int[] cardsTemp1 = mixArr(cardsTemp, null);
					cardsTemp1 = mixArr(cardsTemp1, new int[] { allKindsWhitOutChick[i] });
					int[] restemp = getAllListenSign(cardsTemp1, underCards, kinds, isSelf);
					restemp = rmChickPoint(restemp, cardsTemp1, underCards, num);
					res = mixArr(res, restemp);

					int num2 = count(cardsTemp1, Chick);
					if (num2 > 0) {
						cardsTemp1 = removeN(cardsTemp1, Chick, 1);
						for (int i2 = 0; i2 < allKindsWhitOutChick.length; i2++) {
							int[] cardsTemp2 = mixArr(cardsTemp1, null);
							cardsTemp2 = mixArr(cardsTemp2, new int[] { allKindsWhitOutChick[i2] });
							int[] restemp2 = getAllListenSign(cardsTemp2, underCards, kinds, isSelf);
							restemp2 = rmChickPoint(restemp2, cardsTemp2, underCards, num);

							res = mixArr(res, restemp2);
							int num3 = count(cardsTemp2, Chick);
							if (num3 > 0) {
								cardsTemp2 = removeN(cardsTemp2, Chick, 1);
								for (int i3 = 0; i3 < allKindsWhitOutChick.length; i3++) {
									int[] cardsTemp3 = mixArr(cardsTemp2, null);
									cardsTemp3 = mixArr(cardsTemp3, new int[] { allKindsWhitOutChick[i3] });
									int[] restemp3 = getAllListenSign(cardsTemp3, underCards, kinds, isSelf);
									restemp3 = rmChickPoint(restemp3, cardsTemp3, underCards, num);
									res = mixArr(res, restemp3);
								}
							}
						}
					}
				}
				// 去重复
				res = disDup(res);
				// 删掉4张的叫牌
				res = rmFourCards(res, mixArr(handCards, underCards));
				sort(res);

				return res;
			} else {
				return getAllListenSign(handCards, underCards, kinds, isSelf);
			}

		} else {
			return getAllListenSign(handCards, underCards, kinds, isSelf);
		}

	}

	public static int[] rmChickPoint(int[] res, int[] handCards, int[] underCards, int num) {
		int[] newRes = mixArr(res, null);
		// 删除分不够的叫牌
		for (int i = 0; i < res.length; i++) {
			int point = getAllMaxScoer(addOne(handCards, res[i]), underCards,false);
			if (num == 1) {
				if (point < 4) {
					newRes = remove(newRes, res[i]);
				}
			}
			if (num >= 2) {
				if (point < 8) {
					newRes = remove(newRes, res[i]);
				}
			}
		}
		return newRes;
	}

	/**
	 * 找到所有听牌(包括杠上花) 参数: 牌组,调用前需要先排序
	 * 
	 * @return 所有听牌序列
	 */
	public static int[] getAllListenSign(int[] handCards, int[] underCards, int[] kinds, boolean isSelf) {
		sort(handCards);
		int[] dragons = findDragon(handCards, underCards);
		int[] resDragon = new int[] {};
		int[] resSta = new int[] {};
		int[] res3ping = new int[] {};
		int[] res7pair = new int[] {};
		int[] resPeng = new int[] {};
		int[] res = new int[] {};

		if (dragons.length > 0) {// 两龙的情况 替换两张
			if (dragons.length == 3) {
				for (int index = 0; index < dragons.length; index++) {
					int[] temp = new int[handCards.length];
					int[] rmTemp = new int[] {};
					for (int j = 0; j < handCards.length; j++) {
						temp[j] = handCards[j];
					}
					int indexNext = index + 1;
					if (indexNext == 3) {
						indexNext = 0;
					}

					int handDragon0 = temp[dragons[index]];
					int handDragon1 = temp[dragons[indexNext]];
					if (dragons[index] + 1 < temp.length && temp[dragons[index] + 1] == handDragon0) {
						temp[dragons[index]] = FiveTong;
						temp = replaceN(temp, temp[dragons[index] + 1], -1, 3);
						rmTemp = mixArr(rmTemp, new int[] { handDragon0, handDragon0, handDragon0 });
					} else {
						temp[dragons[index]] = FiveTong;
					}
					if (dragons[indexNext] + 1 < temp.length && temp[dragons[indexNext] + 1] == handDragon1) {
						temp[dragons[indexNext]] = SixTong;
						temp = replaceN(temp, temp[dragons[indexNext] + 1], -1, 3);
						rmTemp = mixArr(rmTemp, new int[] { handDragon1, handDragon1, handDragon1 });
					} else {
						temp[dragons[indexNext]] = SixTong;
					}
					temp = remove(temp, -1);
					sort(temp);
					resDragon = mixArr(resDragon, findListen(temp, kinds, rmTemp, underCards));
				}
			}
			if (dragons.length == 2) {
				int[] temp = new int[handCards.length];
				int[] rmTemp = new int[] {};
				for (int j = 0; j < handCards.length; j++) {
					temp[j] = handCards[j];
				}

				int handDragon0 = temp[dragons[0]];
				int handDragon1 = temp[dragons[1]];
				if (dragons[0] + 1 < temp.length && temp[dragons[0] + 1] == handDragon0) {
					temp[dragons[0]] = FiveTong;
					temp = replaceN(temp, temp[dragons[0] + 1], -1, 3);
					rmTemp = mixArr(rmTemp, new int[] { handDragon0, handDragon0, handDragon0 });
				} else {
					temp[dragons[0]] = FiveTong;
				}
				if (dragons[1] + 1 < temp.length && temp[dragons[1] + 1] == handDragon1) {
					temp[dragons[1]] = SixTong;
					temp = replaceN(temp, temp[dragons[1] + 1], -1, 3);
					rmTemp = mixArr(rmTemp, new int[] { handDragon1, handDragon1, handDragon1 });
				} else {
					temp[dragons[1]] = SixTong;
				}
				temp = remove(temp, -1);
				sort(temp);
				resDragon = findListen(temp, kinds, rmTemp, underCards);
			}

			for (int index = 0; index < dragons.length; index++) {
				int[] res5 = null;
				int[] temp5 = new int[handCards.length];
				int[] rmTemp5 = new int[] {};
				for (int j = 0; j < handCards.length; j++) {
					temp5[j] = handCards[j];
				}
				int handDragon5 = temp5[dragons[index]];
				if (dragons[index] + 1 < temp5.length && temp5[dragons[index] + 1] == handDragon5) {
					temp5[dragons[index]] = FiveTong;
					temp5 = removeN(temp5, temp5[dragons[index] + 1], 3);
					rmTemp5 = mixArr(rmTemp5, new int[] { handDragon5, handDragon5, handDragon5 });
				} else {
					temp5[dragons[index]] = FiveTong;
				}

				sort(temp5);
				int[] dragons5 = findDragon(temp5, underCards);
				if (dragons5.length > 0) {
					for (int index5 = 0; index5 < dragons5.length; index5++) {
						int[] temp56 = new int[temp5.length];
						for (int j = 0; j < temp5.length; j++) {
							temp56[j] = temp5[j];
						}
						int handDragon56 = temp56[dragons5[index5]];
						if (dragons5[index5] + 1 < temp56.length && temp56[dragons5[index5] + 1] == handDragon56) {
							temp56[dragons5[index5]] = SixTong;
							temp56 = removeN(temp56, temp56[dragons5[index5] + 1], 3);
							rmTemp5 = mixArr(rmTemp5, new int[] { handDragon56, handDragon56, handDragon56 });
						} else {
							temp56[dragons5[index5]] = SixTong;
						}
						sort(temp56);
						res5 = mixArr(res5, findListen(temp56, kinds, rmTemp5, underCards));
					}
					res5 = mixArr(res5, findListen(temp5, kinds, rmTemp5, underCards));
				} else if (dragons5.length == 0) {
					res5 = findListen(temp5, kinds, rmTemp5, underCards);
				}

				int[] res6 = null;
				int[] rmTemp6 = new int[] {};
				int[] temp6 = new int[handCards.length];
				for (int j = 0; j < handCards.length; j++) {
					temp6[j] = handCards[j];
				}
				int handDragon6 = temp6[dragons[index]];
				if (dragons[index] + 1 < temp6.length && temp6[dragons[index] + 1] == handDragon6) {
					temp6[dragons[index]] = SixTong;
					temp6 = removeN(temp6, temp6[dragons[index] + 1], 3);
					rmTemp6 = mixArr(rmTemp6, new int[] { handDragon6, handDragon6, handDragon6 });
				} else {
					temp6[dragons[index]] = SixTong;
				}
				sort(temp6);
				int[] dragons6 = findDragon(temp6, underCards);
				if (dragons6.length > 0) {
					for (int index6 = 0; index6 < dragons6.length; index6++) {
						int[] temp65 = new int[temp6.length];
						for (int j = 0; j < temp6.length; j++) {
							temp65[j] = temp6[j];
						}
						int handDragon65 = temp65[dragons6[index6]];
						if (dragons6[index6] + 1 < temp65.length && temp65[dragons6[index6] + 1] == handDragon65) {
							temp65[dragons6[index6]] = FiveTong;
							temp65 = removeN(temp65, temp65[dragons6[index6] + 1], 3);
							rmTemp6 = mixArr(rmTemp6, new int[] { handDragon65, handDragon65, handDragon65 });
						} else {
							temp65[dragons6[index6]] = FiveTong;
						}
						sort(temp65);
						res6 = mixArr(res6, findListen(temp65, kinds, rmTemp6, underCards));
					}
					res6 = mixArr(res6, findListen(temp6, kinds, rmTemp6, underCards));
				} else if (dragons6.length == 0) {
					res6 = findListen(temp6, kinds, rmTemp6, underCards);
				}

				resDragon = mixArr(resDragon, mixArr(res5, res6));

			}

		}
		// System.out.println("杠上花叫牌：" + intToString(resDragon));
		resSta = findListen(handCards, kinds, null, underCards);
		// System.out.println("标准叫牌：" + intToString(resSta));

		// 如果叫牌包含5筒和6筒则把3平头也算进去
		if (findIndex(resSta, FiveTong) != -1 || findIndex(resSta, SixTong) != -1) {
			int[] allCards = mixArr(handCards, underCards);
			// if (findIndex(allCards, FiveTong) != -1 || findIndex(allCards,
			// SixTong) != -1) {
			int[] all3Card = findNTotol(handCards, underCards, 3);
			if (all3Card != null) {
				for (int i = 0; i < all3Card.length; i++) {
					res3ping = addOne(res3ping, allCards[all3Card[i]]);
				}
			}
			// }
		}
		// System.out.println("三姘头叫牌：" + intToString(res3ping));
		resSta = mixArr(resSta, resDragon);
		sort(resSta);
		// 判断是否是胡小七对
		if (isSelf == true) {
			if (handCards.length == 13) {
				res7pair = findListenOf7Pair(handCards, kinds);
			}
		}
		// System.out.println("小七对叫牌：" + intToString(res7pair));

		// 如果不是自摸则去掉手上没有3支的听牌
		if (isSelf == false) {
			List<Integer> newRes = new ArrayList<Integer>();

			if (res3ping != null && res3ping.length > 0) {
				int[] all3Card = findNHand(handCards, null, 3, true);
				for (int i = 0; i < all3Card.length; i++) {
					int temp = handCards[all3Card[i]];
					int index = findIndex(res3ping, temp);
					if (index != -1) {
						newRes.add(res3ping[index]);// 3支的就直接添加
					}
				}
			}
			int[] all2Card = findNHand(handCards, null, 2, false);
			for (int i = 0; i < all2Card.length; i++) {
				int temp = handCards[all2Card[i]];
				int index = findIndex(resSta, temp);
				if (index != -1) {
					// 2支的情况，移除手牌2只
					if (checkBoom2Card(handCards, underCards, temp, kinds) == true) {
						newRes.add(resSta[index]);// 2支的判断后再添加
					}
				}
			}

			resPeng = intListToIntArr(newRes);
			resPeng = disDup(resPeng);
			sort(resPeng);

			resPeng = rmFourCards(resPeng, mixArr(handCards, underCards));
			// System.out.println("点炮叫牌：" + intToString(resPeng));
			return resPeng;
		}

		res = mixArr(res, resSta);
		res = mixArr(res, res3ping);
		res = mixArr(res, res7pair);
		// 去重复
		res = disDup(res);
		// 删掉4张的叫牌
		res = rmFourCards(res, mixArr(handCards, underCards));

		sort(res);
		return res;
	}

	private static int[] rmFourCards(int[] res, int[] cards) {
		for (int i = 0; i < allKinds.length; i++) {
			if (count(cards, allKinds[i]) == 4) {
				res = remove(res, allKinds[i]);
			}
		}

		return res;
	}

	private static int[] replaceN(int[] inHandCards, int inCard, int newCard, int n) {
		int[] handCards = new int[inHandCards.length];
		int count = 0;
		for (int i = 0; i < inHandCards.length; i++) {
			if (inCard == inHandCards[i] && count < n) {
				handCards[i] = newCard;
				count++;
			} else {
				handCards[i] = inHandCards[i];
			}

		}
		return handCards;
	}

	public static int[] removeN(int[] inHandCards, int inCard, int n) {
		
		//try {
			int[] handCards = new int[inHandCards.length - n];
			int ii = 0;
			int count = 0;
			if (handCards.length>0) {
				for (int i = 0; i < inHandCards.length; i++) {

					if (inCard != inHandCards[i]) {
						handCards[ii] = inHandCards[i];
						ii++;
					}

					if (count >= n && inCard == inHandCards[i]) {
						handCards[ii] = inHandCards[i];
						ii++;
					}

					if (inCard == inHandCards[i]) {
						count++;
					}
				}
			}
			return handCards;
//		} catch (Exception e) {
//			System.out.println("移除元素出错: "+intToString(inHandCards)+" inCard:"+inCard+" n:"+n);
//			return inHandCards;
//		}
	}

	private static int[] remove(int[] inHandCards, int inCard) {
		int[] handCards = new int[inHandCards.length - count(inHandCards, inCard)];
		int ii = 0;
		for (int i = 0; i < inHandCards.length; i++) {
			if (inCard != inHandCards[i]) {
				handCards[ii] = inHandCards[i];
				ii++;
			}
		}
		return handCards;
	}

	public static int count(int[] inHandCards, int inCard) {
		int count = 0;
		for (int i = 0; i < inHandCards.length; i++) {
			if (inCard == inHandCards[i]) {
				count++;
			}
		}
		return count;
	}

	private static int[] disDup(int[] array) {
		// 数组去重方法五
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}
		int[] res = new int[set.size()];
		int index = 0;
		for (Integer integer : set) {
			res[index] = integer;
			index++;
		}
		return res;
	}

	private static boolean checkBoom2Card(int[] inHandCards, int[] underCards, int inCard, int[] kinds) {
		boolean isPass = false;
		int[] handCards = removeN(inHandCards, inCard, 2);

		int[] dragons = findDragon(handCards, underCards);
		if (dragons.length == 2) {// 两龙的情况 替换两张
			int[] temp = new int[handCards.length];
			for (int j = 0; j < handCards.length; j++) {
				temp[j] = handCards[j];
			}
			temp[dragons[0]] = FiveTong;
			temp[dragons[1]] = SixTong;
			sort(temp);
			if (checkWin(temp) == 0) {
				isPass = true;
			}
		} else if (dragons.length == 1) {// 一龙的情况先替换5筒再替换6筒
			int[] temp5 = new int[handCards.length];
			for (int j = 0; j < handCards.length; j++) {
				temp5[j] = handCards[j];
			}
			temp5[dragons[0]] = FiveTong;
			sort(temp5);
			int[] dragons5 = findDragon(temp5, underCards);
			if (dragons5.length == 1) {
				int[] temp56 = new int[temp5.length];
				for (int j = 0; j < temp5.length; j++) {
					temp56[j] = temp5[j];
				}
				temp56[dragons5[0]] = SixTong;
				sort(temp56);
				if (checkWin(temp56) == 0) {
					isPass = true;
				}
			} else if (dragons5.length == 0) {
				if (checkWin(temp5) == 0) {
					isPass = true;
				}
			}

			int[] temp6 = new int[handCards.length];
			for (int j = 0; j < handCards.length; j++) {
				temp6[j] = handCards[j];
			}
			temp6[dragons[0]] = SixTong;
			sort(temp6);
			int[] dragons6 = findDragon(temp6, underCards);
			if (dragons6.length == 1) {
				int[] temp65 = new int[temp6.length];
				for (int j = 0; j < temp6.length; j++) {
					temp65[j] = temp6[j];
				}
				temp65[dragons6[0]] = FiveTong;
				sort(temp65);
				if (checkWin(temp65) == 0) {
					isPass = true;
				}
			} else if (dragons6.length == 0) {
				if (checkWin(temp6) == 0) {
					isPass = true;
				}
			}

		}

		return isPass;
	}

	// 两个数组合并
	public static int[] mixArr(int[] arr1, int[] arr2) {
		List<Integer> fullCards = new ArrayList<Integer>();
		if (arr1 != null) {
			for (int i = 0; i < arr1.length; i++) {
				fullCards.add(arr1[i]);
			}
		}
		if (arr2 != null) {
			for (int i = 0; i < arr2.length; i++) {
				fullCards.add(arr2[i]);
			}
		}
		return intListToIntArr(fullCards);
	}

	/**
	 * 找到所有龙牌，返回每组龙的第一只牌的位置 参数: 手牌和碰牌
	 * 
	 * @return 所有碰牌序列
	 */
	private static int[] findDragon(int[] handCards, int[] underCards) {
		List<Integer> allDragon = new ArrayList<Integer>();
		int[] allCards = mixArr(handCards, underCards);
		for (int i = 0; i < handCards.length; i++) {
			int count = 0;
			for (int j = i; j < allCards.length; j++) {
				if (handCards[i] == allCards[j]) {
					count++;
				}
			}
			if (count == 4||count == 7) {
				boolean isHas=false;
				for (int j = 0; j < allDragon.size(); j++) {
					if (handCards[j]==handCards[i]) {
						isHas=true;
					}
				}
				if (isHas==false) {
					allDragon.add(i);
				}
			}
		}

		return intListToIntArr(allDragon);
	}

	/**
	 * 找到所有2张，返回每组的第一只牌的位置 参数: 手牌和碰牌
	 * 
	 * @return 所有碰牌序列
	 */
	public static int[] find2Cards(int[] handCards, int[] underCards) {
		List<Integer> allDragon = new ArrayList<Integer>();
		int[] allCards = mixArr(handCards, underCards);
		for (int i = 0; i < allCards.length; i++) {
			int count = 0;
			for (int j = i; j < allCards.length; j++) {
				if (allCards[i] == allCards[j]) {
					if (i > 0) {
						if (allCards[i] != allCards[i - 1]) {
							count++;
						}

					} else {
						count++;
					}
				}
			}
			if (count == 2) {
				allDragon.add(i);
			}
		}

		return intListToIntArr(allDragon);
	}

	/**
	 * 找到所有n张，返回每组的第一只牌的位置（手牌） 参数: 手牌和碰牌
	 * 
	 * @return 每组的第一只牌的位置
	 */
	public static int[] findNHand(int[] handCards, int[] underCards, int n, boolean isEquls) {
		List<Integer> cards = new ArrayList<Integer>();
		Map<Integer, Integer> unit = new HashMap<Integer, Integer>();
		int[] allCards = mixArr(handCards, underCards);

		for (int i = 0; i < handCards.length; i++) {
			int count = 0;
			if (!unit.containsKey(handCards[i])) {
				for (int j = i; j < allCards.length; j++) {
					if (allCards[i] == allCards[j]) {
						count++;
					}
				}
				unit.put(allCards[i], count);
			}
		}

		for (Map.Entry<Integer, Integer> entry : unit.entrySet()) {
			if (isEquls) {
				if (entry.getValue() == n) {
					cards.add(findIndex(handCards, entry.getKey()));
				}
			} else {
				if (entry.getValue() >= n) {
					cards.add(findIndex(handCards, entry.getKey()));
				}
			}
		}

		return intListToIntArr(cards);
	}

	/**
	 * 找到所有n张，返回每组的第一只牌的位置(全部) 参数: 手牌和碰牌
	 * 
	 * @return 每组的第一只牌的位置
	 */
	public static int[] findNTotol(int[] handCards, int[] underCards, int n) {
		List<Integer> cards = new ArrayList<Integer>();
		Map<Integer, Integer> unit = new HashMap<Integer, Integer>();
		int[] allCards = mixArr(handCards, underCards);

		for (int i = 0; i < allCards.length; i++) {
			int count = 0;
			if (!unit.containsKey(allCards[i])) {
				for (int j = i; j < allCards.length; j++) {
					if (allCards[i] == allCards[j]) {
						count++;
					}
				}
				unit.put(allCards[i], count);
			}

		}

		for (Map.Entry<Integer, Integer> entry : unit.entrySet()) {
			if (entry.getValue() == n) {
				cards.add(findIndex(allCards, entry.getKey()));
			}
		}

		return intListToIntArr(cards);
	}

	/**
	 * 找到所有碰牌 参数: 牌组,调用前需要先排序
	 * 
	 * @return 所有碰牌序列
	 */
	public static int[] findPeng(int[] cards, int[] kinds) {

		List<Integer> allPeng = new ArrayList<Integer>();
		// 牌组和所有类型组合成新牌组
		for (int i = 0; i < kinds.length; i++) {
			if (findIndex(cards, kinds[i]) != -1) {
				if (findDubleIndex(cards, kinds[i]) >= 2) {
					allPeng.add(kinds[i]);
				}
			}
		}

		int[] res = new int[allPeng.size()];
		for (int i = 0; i < allPeng.size(); i++) {
			res[i] = allPeng.get(i);
		}

		return res;
	}
	
	/**
	 * 找到所有吃牌 参数: 牌组,调用前需要先排序
	 * 
	 * @return 所有吃牌序列
	 */
	public static int[] findChi(int[] cards, int[] kinds) {

		List<Integer> allChi = new ArrayList<Integer>();
		// 牌组和所有类型组合成新牌组
		for (int i = 0; i < kinds.length; i++) {
			
			int Small1 = findIndex(cards, kinds[i] - 1);
			int Small2 = findIndex(cards, kinds[i] - 2);
			int biger1 = findIndex(cards, kinds[i] + 1);
			int biger2 = findIndex(cards, kinds[i] + 2);
			if (biger1 != -1 && biger2 != -1) {
				allChi.add(kinds[i]);
			}
			if (Small1 != -1 && Small2 != -1) {
				allChi.add(kinds[i]);
			}
			if (Small1 != -1 && biger1 != -1) {
				allChi.add(kinds[i]);
			}
		}

		int[] res = new int[allChi.size()];
		for (int i = 0; i < allChi.size(); i++) {
			res[i] = allChi.get(i);
		}

		return res;
	}
	
	/**
	 * 找到所有碰牌 参数: 牌组,调用前需要先排序
	 * 
	 * @return 所有碰牌序列
	 */
	public static int[] findPengChick(int[] cards,int[] kinds,boolean isChick) {
		
		if (isChick) {
			int num=count(cards, Chick);
			if (num==0) {
				return findPeng(cards,kinds);
			}else if(num==1){
				return remove(cards, Chick);
			}else if (num>=2) {
				return kinds;
			}else {
				return null;
			}
			
		}else {
			return findPeng(cards,kinds);
		}
		
	}

	/**
	 * 替换牌组 参数: 牌组,调用前需要先排序;进入的牌;出去的牌
	 * 
	 * @return 无
	 */
	public static int[] setInOut(int[] cards, int in, int out) {
		int index = findIndex(cards, out);
		if (index!=-1) {
			if (in == -1) {
				int[] temp = new int[cards.length - 1];
				int j = 0;
				for (int i = 0; i < cards.length; i++) {
					if (index != i) {
						temp[j] = cards[i];
						j++;
					}
				}
				cards = temp;
			} else {
				if (index != -1) {
					cards[index] = in;
				}
				sort(cards);
			}
		}
		return cards;

	}

	/**
	 * 增加一张牌到牌组 参数: 牌组,调用前需要先排序;进入的牌;出去的牌
	 * 
	 * @return 牌组
	 */
	public static int[] addOne(int[] cards, int in) {
		if (in==0) {
			int[] temp = new int[cards.length];
			for (int i = 0; i < cards.length; i++) {
				temp[i] = cards[i];
			}
			return temp;
		}else {
			int[] temp = new int[cards.length + 1];
			for (int i = 0; i < cards.length; i++) {
				temp[i] = cards[i];
			}
			temp[cards.length] = in;
			sort(temp);
			return temp;
		}
		
	}

	/**
	 * 增加一张牌到牌组(不排序版) 参数: 牌组,调用前需要先排序;进入的牌;出去的牌
	 * 
	 * @return 牌组
	 */
	public static int[] addOneNoSort(int[] cards, int in) {
		int[] temp = new int[cards.length + 1];
		for (int i = 0; i < cards.length; i++) {
			temp[i] = cards[i];
		}
		temp[cards.length] = in;
		return temp;
	}

	
	/**
	 * 碰牌处理 参数: 牌组1;牌组2;要换的牌组(每支只换一张)
	 * 
	 * @return 无
	 */
	public static int[][] underSwapArr(int[] hand, int[] under, int[] inArr) {
		int j = under.length;
		int count=inArr.length;
		int[] tempUnder = new int[j +count];
		int[] tempHand =hand;

		for (int i = 0; i < under.length; i++) {
			tempUnder[i] = under[i];
		}
		
		for (int n = 0; n < inArr.length; n++) {
			int index=findIndex(hand, inArr[n]);
			tempUnder[j+n]=hand[index];
			tempHand=removeN(tempHand, inArr[n], 1);
		}
		
		hand = tempHand;
		under = tempUnder;
		sort(hand);
		sort(under);
		int[][] res = new int[2][];
		res[0] = hand;
		res[1] = under;
		return res;
	}
	
	/**
	 * 碰牌处理 参数: 牌组1;牌组2;碰牌
	 * 
	 * @return 无
	 */
	public static int[][] underSwap(int[] hand, int[] under, int peng) {
		int j = under.length;
		int[] tempUnder = new int[j + 3];
		int m = 0;
		int[] tempHand = new int[hand.length - 3];

		for (int i = 0; i < under.length; i++) {
			tempUnder[i] = under[i];
		}

		for (int i = 0; i < hand.length; i++) {
			if (hand[i] == peng && j < under.length + 3) {
				tempUnder[j] = hand[i];
				j++;
			} else {
				tempHand[m] = hand[i];
				m++;
			}
		}
		hand = tempHand;
		under = tempUnder;
		sort(hand);
		sort(under);
		int[][] res = new int[2][];
		res[0] = hand;
		res[1] = under;
		return res;
	}
	
	/**
	 * 碰牌处理 参数: 牌组1;牌组2;碰牌
	 * 
	 * @return 无
	 */
	public static int[][] underSwapChick(int[] hand, int[] under, int peng,boolean isChick) {
		if (isChick) {
			int j = under.length;
			int num=count(hand, peng);
			if (num>3) {
				num=3;
			}
			
			int[] tempUnder = new int[j + num];
			int m = 0;
			int[] tempHand = new int[hand.length - num];

			for (int i = 0; i < under.length; i++) {
				tempUnder[i] = under[i];
			}

			for (int i = 0; i < hand.length; i++) {
				if (hand[i] == peng && j < under.length + num) {
					tempUnder[j] = hand[i];
					j++;
				} else {
					tempHand[m] = hand[i];
					m++;
				}
			}
			
			tempHand=removeN(tempHand, Chick, 3-num);
			for (int i = 0; i < 3-num; i++) {
				tempUnder=addOne(tempUnder, peng);
			}
			hand = tempHand;
			under = tempUnder;
			sort(hand);
			sort(under);
			int[][] res = new int[2][];
			res[0] = hand;
			res[1] = under;
			return res;
		}else {
			return underSwap(hand,under,peng);
		}
		
	}

	public static String intToString(int[] deskCards) {
		String out = "";
		for (int i = 0; i < deskCards.length; i++) {
			out += getName(deskCards[i]);
			out += "  ";
			if ((i + 1) % 17 == 0) {
				out += "\n";
			}
			if ((i + 1) % 34 == 0) {
				out += "\n";
			}
		}
		return out;
	}

	public static String intToCode(int[] deskCards) {
		String out = "";
		for (int i = 0; i < deskCards.length; i++) {
			out += deskCards[i];
			out += "|";
		}
		return out;
	}

	public static String intToZero(int[] deskCards) {
		String out = "";
		for (int i = 0; i < deskCards.length; i++) {
			if (deskCards[i] > 0) {
				out += 99;
				out += "|";
			}
		}
		return out;
	}

	public static int countInt(int[] deskCards) {
		int total = 0;
		for (int i : deskCards) {
			total += i;
		}
		return total;
	}

	public static int getAICard(int[] Cards, int onHand, boolean isChick) {
		int[] temp;
		if (onHand == -1) {
			temp = addOne(Cards, onHand);
		} else {
			temp = Cards;
		}
		int res = -1;
		sort(temp);
		int solo = checkSoloAi(temp, isChick);
		if (solo != -1) {
			res = solo;
		} else {
			Random ran = new Random();
			int number = 0;
			if (onHand == -1) {
				number = ran.nextInt(Cards.length);
			} else {
				number = ran.nextInt(Cards.length + 1);
			}

			if (number >= Cards.length) {
				res = onHand;
			} else {
				res = Cards[number];
			}

			if (isChick && res == Chick) {
				res = getAICard(Cards, onHand, isChick);
			}

		}

		return res;

	}

	/**
	 * 判断是否存在单身牌(AI专用) 参数: 牌组,调用前需要先排序
	 * 
	 * @param isChick
	 * 
	 * @return 单身牌数字;-1不存在;
	 */
	public static int checkSoloAi(int[] cards, boolean isChick) {
		int temp = -1;
		for (int i = 0; i < cards.length; i++) {
			int isBiger = 0;
			int isSmall = 0;
			int count = 0;
			for (int j = 0; j < cards.length; j++) {
				if (i != j && cards[i] == cards[j]) {// 检查是否重复
					count++;
					// System.out.println("发现重复");
				}
				if (cards[i] + 1 == cards[j]) {
					isSmall++;
					// System.out.println("发现小牵手");
				}
				if (cards[i] - 1 == cards[j]) {
					isBiger++;
					// System.out.println("发现大牵手");
				}
			}
			if (isSmall + isBiger + count == 0) {
				// System.out.println("单身牌检测未通过:"+intToString(cards));
				temp = cards[i];
			}
		}
		// System.out.println("单身牌检测通过,开始切割作业:"+intToString(cards));
		if (isChick && temp == Chick) {
			return -1;
		}
		return temp;
	}


}
