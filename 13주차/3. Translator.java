package master;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Translator extends JFrame{
	
	private class Word{ //공개 클래스가 아닌 InnerClass 로 선언
		
		private String han_word; //필드로는 han_word
		private String eng_word; //eng_word 가 있다.
		public Word(String han_word,String eng_word) { //생성자로 한글단여, 영어 단어를  받고 필드에 저장한다.
			this.han_word = han_word;
			this.eng_word = eng_word;
		}
		
		//수정할 필요 없으므로 getter 만 선언 
		public String getHan_word() {	return han_word;	}
		
		public String getEng_word() {	return eng_word;	}
		
	}
	
	private ArrayList<Word> Data; //Translator의 필드로 Word 객체를 담는 ArrayList 생성
	
	
	
	public Translator() {
		super("English Translator"); //타이틀을 English Translator 로설정
		this.setLayout(new FlowLayout()); //Flow Layout 을 배치 관리자로 설정
		this.setSize(900,300); //윈도우 창 크기 설정
		JPanel EnglishPanel = new JPanel(); //영문 입력이랑 번역 버튼을 담는 JPanel 생성
		EnglishPanel.setLayout(new BorderLayout()); //영어 입력창은 위, 번역버튼을 오른쪽 아래에 있으므로 Border Layout 사용
		JTextArea EnglishInput = new JTextArea(10,30); //세로로 긴 입력착을 만들어야 하므로 JTextArea 사용
		EnglishPanel.add(EnglishInput,BorderLayout.NORTH); //입력창은  BorderLayout 기준 north 에 있으므로 North 로 설정
		JButton TranslateButton = new JButton("번역"); //번역 버튼 생성
		EnglishPanel.add(TranslateButton,BorderLayout.EAST); //번역 창은 BorderLayout 기준, East 에 있으므로 East 로 설정
		
		
		JPanel KoreanPanel = new JPanel();//번역된 결과랑 취소 버튼을 담는 JPanel 생성
		KoreanPanel.setLayout(new BorderLayout()); //번역된 결과 위, 취소버튼을 왼쪽 아래에 있으므로 Border Layout 사용
		JTextArea KoreanResult = new JTextArea(10,30); //세로로 긴 입력착을 만들어야 하므로 JTextArea 사용
		KoreanPanel.add(KoreanResult,BorderLayout.NORTH); //입력창은  BorderLayout 기준 north 에 있으므로 North 로 설정
		JButton CancelButton = new JButton("취소"); //취소 버튼 생성
		KoreanPanel.add(CancelButton,BorderLayout.WEST); //번역 창은 BorderLayout 기준, East 에 있으므로 West 로 설정
		addData();
		
		TranslateButton.addActionListener(new ActionListener() { //번역 버튼의 동작 지정

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String input = EnglishInput.getText(); //사용자에게 입력 받은걸 가져와서 input 에 저장
				input = input.trim(); //trim 메소드를 호출하여, 앞 뒤 공백 제거
				String output = "정보 없음!"; //출력할 정보
				for (Word w : Data) { //Data 필드의 원소 하나하나를 가져와서 돌린다 - for each 문
					if ((w.getEng_word()).equals(input)){ //w 에서 가져온 영어가 입력한거랑 같으면
						output = w.getHan_word(); //출력할 정보는 w 에서 가져온 한글 정보
						break; //더이상 for 문을 볼 필요 없ㅇ므
					}
				}
				KoreanResult.setText(output); //번역 결과를 설정해준다
			}
			
		});
		
		CancelButton.addActionListener(new ActionListener() {
			//취소 버튼이 눌리면, 입력 출력을 초기화 해야된다.
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KoreanResult.setText(""); //출력 초기화
				EnglishInput.setText(""); //입력 초기화
			}
			
		});
		
		this.add(EnglishPanel);//EnglishPanel 을 JFrame 에 추가한다
		this.add(KoreanPanel);//KoreanPanel 을 JFrame 에 추가한다.
		
		this.setVisible(true); //해당 JFrame 이 보여지게 한다
		
		
		
		
	}
	
	private void addData() { //Data 필드에 값을 넣는 작업
		this.Data = new ArrayList<Word>(); //Data 필드를 객체를 할당 해준다.
		Data.add(new Word("…처럼\n…으로서\n…하면서","as"));
		Data.add(new Word("… 및 …\n그리고\n…하고\n또","and"));
		Data.add(new Word("모든\n모두\n다\n전부\n전체","all"));
		Data.add(new Word("…에 대하여\n약…\n정도\n좀\n거의","about"));
		Data.add(new Word("…에\n…으로\n…에서","at"));
		Data.add(new Word("행동하다\n법률\n연기하다\n행위\n대행하다","act"));
		Data.add(new Word("…후에\n…뒤에\n다음의\n그 후\n나중에","after"));
		Data.add(new Word("팔\n무기\n무장하다\n부문\n팔걸이","arm"));
		Data.add(new Word("답하다\n대답\n해답\n전화를 받다\n응답하다","answer"));
		Data.add(new Word("공기\n대기\n항공의\n공군의\n하늘의","air"));
		Data.add(new Word("나이\n시대\n노인들\n오래되다\n오랫동안","age"));
		Data.add(new Word("떨어져\n멀리\n떠나\n당장\n사라져","away"));
		Data.add(new Word("공격하다\n발작\n비난하다\n덤벼들다\n폭행하다","attack"));
		Data.add(new Word("묻다\n요청하다\n질문하다\n부탁하다\n말씀하다","ask"));
		Data.add(new Word("문제\n일\n사건\n정사\n행사","affair"));
		Data.add(new Word("주변에\n주위에\n돌아다니는\n근처에","around"));
		Data.add(new Word("위에\n이상인\n하늘에\n상기(上記)한","above"));
		Data.add(new Word("어떤\n전혀\n아무\n어느\n누군가","any"));
		Data.add(new Word("목표\n목적\n겨냥하다\n노리다\n조준하다","aim"));
		Data.add(new Word("지역\n분야\n영역\n면적\n지방","area"));
		Data.add(new Word("…에 대한\n반대로\n대항하여\n반하는\n기대어서","against"));
		Data.add(new Word("주소\n연설하다\n해결하다\n이야기하다\n부르다","address"));
		Data.add(new Word("인정하다\n시인하다\n입원시키다\n허가하다\n승인하다","admit"));
		Data.add(new Word("주장하다\n논쟁하다\n논의하다\n말다툼하다\n왈가왈부하다","argue"));
		Data.add(new Word("조언\n충고\n도움\n권고\n지시","advice"));
		Data.add(new Word("동의하다\n합의하다\n일치하다\n승낙하다\n제안에 응하다","agree"));
		Data.add(new Word("참석하다\n다니다\n주의하다\n돌보다","attend"));
		Data.add(new Word("시도하다\n노력\n기도하다\n계획하다\n미수","attempt"));
		Data.add(new Word("…중에\n대한\n상호간에\n…사이에\n가운데","among"));
		Data.add(new Word("사고\n교통사고\n재난\n우연한 사고\n사건","accident"));
		Data.add(new Word("함께\n…을 따라\n동안에\n가지고\n계속","along"));
		Data.add(new Word("화난\n성난\n격렬한","angry"));
		Data.add(new Word("혼자\n홀로\n다만 …뿐이다\n고립하여","alone"));
		Data.add(new Word("동물\n짐승\n야수","animal"));
		Data.add(new Word("…할 수 있게 하다\n허용하다\n허락하다","allow"));
		Data.add(new Word("받아들이다\n수용하다\n인정하다\n입학시키다\n응하다","accept"));
		Data.add(new Word("다른\n또\n하나\n더\n다시","another"));
		Data.add(new Word("살아 있는\n생기에 넘치는\n이 세상의\n계속하여\n생생한","alive"));
		Data.add(new Word("깨다\n잠에서 깨다\n깨어나다","awake"));
		Data.add(new Word("거의\n대부분\n약\n…에 가까운\n하마터면","almost"));
		Data.add(new Word("나타나다\n…처럼 보이다\n출연하다\n…인 듯하다\n생기다","appear"));
		Data.add(new Word("두려운\n무서워하여\n걱정인\n것 같다\n미안하지만","afraid"));
		Data.add(new Word("…할 수 있는\n유능한\n자격 있는\n수완 있는","able"));
		Data.add(new Word("도착하다\n오다\n가다\n도래하다\n도달하다","arrive"));
		Data.add(new Word("불안한\n하고 싶어하는\n걱정스러운","anxious"));
		Data.add(new Word("오후\n점심","afternoon"));
		Data.add(new Word("… 전역에서\n가로질러서\n걸쳐서\n건너다\n지름으로","across"));
		Data.add(new Word("무엇이든\n어느 것이든\n아무것도\n조금이라도","anything"));
		Data.add(new Word("다시\n또\n다시 한 번","again"));
		Data.add(new Word("조언하다\n권하다\n알리다\n…하는 게 좋다\n상담하다","advise"));
		Data.add(new Word("피하다\n회피하다\n막다\n자제하다\n예방하다","avoid"));
		Data.add(new Word("좋아\n알았어\n괜찮아\n자\n무사한","all right"));
		Data.add(new Word("항상\n언제나\n늘\n반드시\n줄곧","always"));
		Data.add(new Word("애플\n사과\n사과나무\n뉴욕","apple"));
		Data.add(new Word("돕다\n보조\n지원하다\n어시스트\n조력하다","assist"));
		Data.add(new Word("이렇다할 사람\n누군가\n아무나","anybody"));
		Data.add(new Word("누군가\n모든 사람\n아무도","anyone"));
		Data.add(new Word("부정관사 a","an"));
		Data.add(new Word("전\n지난\n이전\n전년\n오래전에","ago"));
		Data.add(new Word("덧붙이다\n더하다\n추가하다\n포함시키다\n증가하다","add"));
		Data.add(new Word("잠들어\n자는\n조는","asleep"));
		Data.add(new Word("이미\n벌써\n충분히\n이전에\n지금까지","already"));
		Data.add(new Word("달성하다\n성취하다\n…을 이루다\n획득하다","achieve"));
		Data.add(new Word("똑같이\n모두\n비슷한\n한결같이","alike"));
		Data.add(new Word("또한\n역시\n뿐만 아니라\n마찬가지로\n게다가","also"));
		Data.add(new Word("be의 1인칭·단수·직설법·현재형\n오전","am"));
		Data.add(new Word("1.","american"));
		Data.add(new Word("가을","autumn"));
		Data.add(new Word("회계\n차지하다\n계좌\n말\n보고","account"));
		Data.add(new Word("행동\n전투\n액션\n효과\n소송","action"));
		Data.add(new Word("발전\n진출\n진보\n발달\n나아가다","advance"));
		Data.add(new Word("예술\n미술품\n미술\n아트\n기술","art"));
		Data.add(new Word("당국\n권한\n권위\n권위자\n권력","authority"));
		Data.add(new Word("호소\n매력\n항소\n마음에 들다\n상고","appeal"));
		Data.add(new Word("능동적인\n활동적인\n적극적인\n활발한\n현역의","active"));
		Data.add(new Word("관심\n주의력\n주의\n주목\n집중","attention"));
		Data.add(new Word("지원\n원조\n도움\n구호\n보조","aid"));
		Data.add(new Word("논문\n기사\n조항\n물건\n관사","article"));
		Data.add(new Word("접근하다\n접근법\n방법\n다가오다\n도달하다","approach"));
		Data.add(new Word("배열\n합의\n계약\n계획\n준비","arrangement"));
		Data.add(new Word("외모\n출연\n겉모습\n출전\n출석","appearance"));
		Data.add(new Word("주장\n논쟁\n말다툼\n논점\n논거","argument"));
		Data.add(new Word("능력\n수 있다\n력\n기능\n재능","ability"));
		Data.add(new Word("8월","august"));
		Data.add(new Word("대안\n대체\n대신의\n다른\n얼터너티브","alternative"));
		Data.add(new Word("적용하다\n지원하다\n신청하다\n응용하다\n바르다","apply"));
		Data.add(new Word("관객\n청중\n관중\n시청자\n독자","audience"));
		Data.add(new Word("양\n되다\n금액\n달하다\n액수","amount"));
		Data.add(new Word("각도\n관점\n모서리","angle"));
		Data.add(new Word("아는 사람\n인물\n친지\n만남","acquaintance"));
		Data.add(new Word("합의\n협정\n동의\n계약\n조화","agreement"));
		Data.add(new Word("가정하다\n생각하다\n추측하다\n추정하다\n맡다","assume"));
		Data.add(new Word("배치하다\n준비하다\n마련하다\n정리하다\n계획하다","arrange"));
		Data.add(new Word("어색한\n거북한\n서투른\n곤란한\n난처한","awkward"));
		Data.add(new Word("평균\n보통의","average"));
		Data.add(new Word("알아주다\n감사하다\n감상하다\n고마워하다\n인정하다","appreciate"));
		Data.add(new Word("영향을 주다\n작용하다\n감염시키다\n…체하다","affect"));
		Data.add(new Word("에이전트\n요원\n대리인\n첩보원\n행위자","agent"));
		Data.add(new Word("활동\n활성\n행위\n레저\n기능","activity"));
		Data.add(new Word("태도\n자세\n행동\n의식\n관점","attitude"));
		Data.add(new Word("알고 있는\n인식하는\n깨달은\n의식하는","aware"));
		Data.add(new Word("입학\n입장\n입원\n인정\n승인","admission"));
		Data.add(new Word("승인\n허가\n동의\n찬성","approval"));
		Data.add(new Word("군\n군대\n육군","army"));
		Data.add(new Word("가능한\n이용할 수 있는\n유효한\n유용한\n시간이 있는","available"));
		Data.add(new Word("없음\n부족\n결석\n공백","absence"));
		Data.add(new Word("임명\n약속\n예약","appointment"));
		Data.add(new Word("양상\n측면\n~면\n관점\n국면","aspect"));
		Data.add(new Word("이점\n우위\n유리\n이익\n혜택","advantage"));
		Data.add(new Word("비록…이지만\n…임에도 불구하고\n…이지만","although"));
		Data.add(new Word("4월","april"));
		Data.add(new Word("연간의\n연례의\n매년의\n연마다의\n해마다","annual"));
		Data.add(new Word("해외에\n외국에\n널리","abroad"));
		Data.add(new Word("상\n수여하다\n어워드\n상금","award"));
		Data.add(new Word("기관\n소속사\n대행\n에이전시\n대리점","agency"));
		Data.add(new Word("분노\n화\n분개\n노여움","anger"));
		Data.add(new Word("조정되다\n적응하다\n조절하다\n감안하다\n맞추다","adjust"));
		Data.add(new Word("끔찍한\n엄청난\n지독한\n심한\n이상한","awful"));
		Data.add(new Word("타고\n배로\n배 위에\n승선하여\n기내에","aboard"));
		Data.add(new Word("광고","advertisement"));
		Data.add(new Word("추가\n덧셈\n등재\n증축","addition"));
		Data.add(new Word("아파트","apartment"));
		Data.add(new Word("체포하다\n구속하다\n검거하다\n억류하다\n저지하다","arrest"));
		Data.add(new Word("사과하다\n사죄하다\n죄송하다\n미안하다","apologize"));
		Data.add(new Word("매력적인\n매혹적인","attractive"));
		Data.add(new Word("발표하다\n밝히다\n알리다\n공표하다","announce"));
		Data.add(new Word("떨어진\n분리된\n분해하는\n구별되는\n따로","apart"));
		Data.add(new Word("채택하다\n입양하다\n도입하다\n취하다\n적용하다","adopt"));
		Data.add(new Word("불안\n걱정\n염려\n근심\n긴장","anxiety"));
		Data.add(new Word("고대의\n오래된\n옛날의","ancient"));
		Data.add(new Word("여유가 있다\n할 수 있다","afford"));
		Data.add(new Word("앨범\n음반","album"));
		Data.add(new Word("끌다\n유치하다\n유혹하다\n유인하다","attract"));
		Data.add(new Word("도착\n등장\n탄생","arrival"));
		Data.add(new Word("앞서\n앞에\n미리\n빠르게","ahead"));
		Data.add(new Word("공격적인\n적극적인\n활동적인\n과감한\n강력한","aggressive"));
		Data.add(new Word("산\n신\n신랄한\nLSD","acid"));
		Data.add(new Word("임명하다\n지명하다\n지정하다","appoint"));
		Data.add(new Word("얻다\n인수하다\n갖다\n배우다\n구입하다","acquire"));
		Data.add(new Word("정확한\n정밀한\n올바른\n일치한\n적중","accurate"));
		Data.add(new Word("be의 복수형 및 2인칭·단수·직설법·현재\n면적의 단위(아르)","are"));
		Data.add(new Word("1.","america"));
		Data.add(new Word("호주\n오스트레일리아","australia"));
		Data.add(new Word("아시아","asia"));
		Data.add(new Word("먹었다","ate"));
		Data.add(new Word("모험\n어드벤처\n도전","adventure"));
		Data.add(new Word("작가\n저자\n필자\n저술가","author"));
		Data.add(new Word("없는\n결석한\n불참한\n결여된","absent"));
		Data.add(new Word("예술가\n아티스트\n화가\n미술가\n가수","artist"));
		Data.add(new Word("부끄러워\n창피한\n수치스러운","ashamed"));
		Data.add(new Word("정부\n행정\n정권\n관리\n경영","administration"));
		Data.add(new Word("어쨌든\n아무튼\n어차피\n그래서\n결국","anyway"));
		Data.add(new Word("협회\n관련\n연합\n단체\n조합","association"));
		Data.add(new Word("광고하다\n홍보하다\n선전하다\n알리다","advertise"));
		Data.add(new Word("실제의\n사실상의\n진짜의\n현재의","actual"));
		Data.add(new Word("~만\n하지만\n그러나\n아니면\n뿐만 아니라","but"));
		Data.add(new Word("…에 의하여","by"));
		Data.add(new Word("…이다\n있다\n존재하다","be"));
		Data.add(new Word("돌아가다\n뒤\n등\n후퇴하다","back"));
		Data.add(new Word("침대\n…층(層)\n재우다\n무덤","bed"));
		Data.add(new Word("타다\n화상\n연소하다\n소비하다\n굽다","burn"));
		Data.add(new Word("블록\n차단\n막다\n구역\n봉쇄","block"));
		Data.add(new Word("기반\n기초\n위치하다\n…로 만든\n기지","base"));
		Data.add(new Word("위원회\n…판\n이사회\n보드\n탑승하다","board"));
		Data.add(new Word("책\n도서\n서적\n저서\n예약하다","book"));
		Data.add(new Word("큰\n중요한\n많이\n대단한","big"));
		Data.add(new Word("나쁜\n좋지 않은\n잘못된\n심한\n상한","bad"));
		Data.add(new Word("뒤의\n숨겨진\n뒤진\n늦은\n등","behind"));
		Data.add(new Word("최고의\n가장 …한\n최선의\n베스트\n최대의","best"));
		Data.add(new Word("기업\n사업\n경영\n산업\n비즈니스","business"));
		Data.add(new Word("전\n이전에\n적\n앞에","before"));
		Data.add(new Word("몸\n신체\n단체\n시체\n몸매","body"));
		Data.add(new Word("사다\n구입\n믿다\n얻다\n준비하다","buy"));
		Data.add(new Word("믿다\n생각하다\n신뢰하다\n신앙\n신용하다","believe"));
		Data.add(new Word("더 나은\n더 좋은","better"));
		Data.add(new Word("아기\n새끼\n어린이용의\n자기","baby"));
		Data.add(new Word("시작하다\n발생하다\n착수하다\n출발하다","begin"));
		Data.add(new Word("빵\n생계","bread"));
		Data.add(new Word("검은\n흑인의\n블랙의\n흑","black"));
		Data.add(new Word("아래에\n…이하의\n영하의","below"));
		Data.add(new Word("끓이다\n비등\n삶다\n익히다\n졸이다","boil"));
		Data.add(new Word("속하다\n…의 것이다\n소유하다\n어울리다","belong"));
		Data.add(new Word("새\n조류","bird"));
		Data.add(new Word("…을 넘어서\n…이상으로\n뛰어넘는\n…이후\n…이외는","beyond"));
		Data.add(new Word("사이에\n…간의\n둘\n양측","between"));
		Data.add(new Word("상자\n박스\n…함\n틀\n권투","box"));
		Data.add(new Word("파란\n푸른\n하늘색의\n블루스\n우울한","blue"));
		Data.add(new Word("밝은\n영리한\n빛나는\n긍정적인\n환한","bright"));
		Data.add(new Word("가지고 다니다\n일으키다\n가져다 주다\n데려오다\n생기다","bring"));
		Data.add(new Word("아름다운\n멋있는\n훌륭한\n예쁜\n화창한","beautiful"));
		Data.add(new Word("바쁜\n분주한\n붐비다\n통화 중인","busy"));
		Data.add(new Word("아침\n아침식사\n조식","breakfast"));
		Data.add(new Word("건물\n건축\n빌딩","building"));
		Data.add(new Word("소년\n아이\n남자\n학생\n아들","boy"));
		Data.add(new Word("버스\n시내버스","bus"));
		Data.add(new Word("건축하다\n만들다\n짓다\n세우다\n기르다","build"));
		Data.add(new Word("둘 모두에게\n두 …\n양쪽의\n양자\n쌍방의","both"));
		Data.add(new Word("공\n볼\n구기\n무도회\n투구","ball"));
		Data.add(new Word("형제\n동포\n형씨","brother"));
		Data.add(new Word("태어난\n…태생의\n타고난","born"));
		Data.add(new Word("배\n보트","boat"));
		Data.add(new Word("목욕하다\n감싸다","bathe"));
		Data.add(new Word("…때문에\n왜냐하면\n…하다고 해서","because"));
		Data.add(new Word("빌리다\n대여하다\n차용하다\n빚지다","borrow"));
		Data.add(new Word("…이 되다\n…해지다\n어울리다","become"));
		Data.add(new Word("용감한\n용기\n무릅쓰다\n멋진\n용사","brave"));
		Data.add(new Word("곁에\n가\n벗어난\n비교하면","beside"));
		Data.add(new Word("이기다\n때리다\n물리치다\n비트\n뛰다","beat"));
		Data.add(new Word("바\n술집\n막대\n판매대","bar"));
		Data.add(new Word("타격\n불다\n울리다","blow"));
		Data.add(new Word("곰\n부담하다\n참다\n맺다","bear"));
		Data.add(new Word("법안\n빌\n지폐\n증권\n청구서","bill"));
		Data.add(new Word("물다\n한 입\n물린 곳\n깨물다\n물어뜯다","bite"));
		Data.add(new Word("균형\n안정\n조화\n잔고","balance"));
		Data.add(new Word("한계\n묶인\n행\n얽매인\n의존","bound"));
		Data.add(new Word("터지다\n터뜨리다\n폭발하다\n무너지다\n분출하다","burst"));
		Data.add(new Word("혈액\n피\n혈통\n혈연\n유혈","blood"));
		Data.add(new Word("전투\n싸움\n전쟁\n투쟁\n대결","battle"));
		Data.add(new Word("시각장애의\n블라인드\n맹인의\n맹목적인\n장님의","blind"));
		Data.add(new Word("예산안\n예산\n재정","budget"));
		Data.add(new Word("10억\n막대한 수","billion"));
		Data.add(new Word("가방\n봉지\n백\n주머니\n봉투","bag"));
		Data.add(new Word("은행\n뱅크\n강둑","bank"));
		Data.add(new Word("구부러지다\n휘다\n숙이다\n굴절되다\n굴복시키다","bend"));
		Data.add(new Word("신념\n믿음\n생각\n소신\n신조","belief"));
		Data.add(new Word("결합하다\n구속되다\n묶다\n속박하다\n곤경","bind"));
		Data.add(new Word("숨\n호흡\n냄새\n숨결","breath"));
		Data.add(new Word("국경\n경계\n접해 있다\n인접하다\n가깝다","border"));
		Data.add(new Word("비난하다\n...탓하다\n책임\n나무라다","blame"));
		Data.add(new Word("흥정하다\n매매 계약\n헐값\n싼 물건","bargain"));
		Data.add(new Word("바닥\n아래\n밑바닥\n하위\n최하의","bottom"));
		Data.add(new Word("넓은\n광\n광범위한\n더욱\n폭넓은","broad"));
		Data.add(new Word("시작\n초\n처음\n기원\n개시","beginning"));
		Data.add(new Word("병\n병에 담다\n우유\n용기\n술","bottle"));
		Data.add(new Word("탄생\n출생\n태어남\n출산\n낳다","birth"));
		Data.add(new Word("닦다\n양치\n붓\n빗다\n브러시","brush"));
		Data.add(new Word("행동하다\n처신하다\n작용하다","behave"));
		Data.add(new Word("조금\n약간","bit"));
		Data.add(new Word("벨트\n허리띠\n띠\n지대","belt"));
		Data.add(new Word("부르다\n전화하다\n말하다\n요구하다\n이름","call"));
		Data.add(new Word("가까운\n닫다\n가까이에\n숨겨진\n친한","close"));
		Data.add(new Word("휴대하다\n싣다\n옮기다\n운반하다\n갖다","carry"));
		Data.add(new Word("카드\n…표(票)\n명함\n엽서\n카드놀이","card"));
		Data.add(new Word("할 수 있다\n캔\n통조림","can"));
		Data.add(new Word("배역\n주조\n투표하다\n던지다\n드리우다","cast"));
		Data.add(new Word("분명해지다\n분명한\n밝아지다\n명확하다\n확실히","clear"));
		Data.add(new Word("오다\n되다\n나오다\n가다\n일어나다","come"));
		Data.add(new Word("경우\n환자\n사건\n상자\n소송","case"));
		Data.add(new Word("잡다\n받다\n걸리다\n체포하다\n적발하다","catch"));
		Data.add(new Word("깨끗한\n청소하다\n맑은\n치우다\n지우다","clean"));
		Data.add(new Word("색\n색깔\n색채\n컬러\n색상","color"));
		Data.add(new Word("덮다\n부담하다\n가리다\n표지\n취재하다","cover"));
		Data.add(new Word("추운\n차가워진\n감기\n추위\n콜드의","cold"));
		Data.add(new Word("해나가다\n하다\n일\n되어가다\n들어주다","do"));
		Data.add(new Word("하락\n떨어지다\n떨어뜨리다\n그만두다\n내리다","drop"));
		Data.add(new Word("그리다\n끌다\n긋다\n만들다\n받다","draw"));
		Data.add(new Word("운전하다\n구동하다\n차로\n드라이브\n가다","drive"));
		Data.add(new Word("죽은\n시신\n사망\n다 되다\n돌아가신","dead"));
		Data.add(new Word("개\n애완견\n강아지\n도그\n개고기","dog"));
		Data.add(new Word("건조한\n말린\n마른\n건성의\n드라이","dry"));
		Data.add(new Word("깊은\n심\n매우\n많다\n딥","deep"));
		Data.add(new Word("입다\n옷\n드레스\n복장\n변장","dress"));
		Data.add(new Word("데이트\n날짜\n…일\n시작되다\n만나다","date"));
		Data.add(new Word("날\n하루\n낮\n데이\n시절","day"));
		Data.add(new Word("직접의\n감독하다\n연출하다\n지시하다","direct"));
		Data.add(new Word("죽다\n사망하다\n사라지다\n떠나다\n꺼지다","die"));
		Data.add(new Word("꿈\n꿈꾸다\n드림\n상상하다\n희망","dream"));
		Data.add(new Word("평평해지다\n균등해지다\n백중해지다\n같은","even"));
		Data.add(new Word("눈\n시선\n안구\n쳐다보다\n눈길","eye"));
		Data.add(new Word("먹다\n음식\n먹을 것\n식\n식사","eat"));
		Data.add(new Word("쉬운\n좋은\n편하게\n용이한\n수월하게","easy"));
		Data.add(new Word("변명\n핑계\n참아주다\n이유\n구실","excuse"));
		Data.add(new Word("예상하다\n기대하다\n생각하다\n바라다\n요구하다","expect"));
		Data.add(new Word("예\n본보기\n사례\n모범\n예제","example"));
		Data.add(new Word("달걀\n알\n난자\n에그","egg"));
		Data.add(new Word("영향\n효과\n발효\n결과\n현상","effect"));
		Data.add(new Word("지금까지\n이전에\n항상\n언제까지나\n여태까지","ever"));
		Data.add(new Word("교환\n환율\n거래소\n주고 받다\n바꾸다","exchange"));
		Data.add(new Word("평등한\n동등한\n같은\n동일한\n균등한","equal"));
		Data.add(new Word("경험\n체험\n겪다\n느끼다\n경력","experience"));
		Data.add(new Word("초기\n초\n일찍\n이른\n어린","early"));
		Data.add(new Word("자유의\n무료의\n…이 없는\n해방시키다\n벗어난","free"));
		Data.add(new Word("날다\n비행하다\n파리\n빠르다\n비행기를 타다","fly"));
		Data.add(new Word("떨어지다\n가을\n감소하다\n하락하다\n폭포","fall"));
		Data.add(new Word("…을 위하여\n…을 기념하여\n…용의","for"));
		Data.add(new Word("분야\n현장\n들판\n경기장\n…장(場)","field"));
		Data.add(new Word("고치다\n고정하다\n해결하다\n음식을 준비하다\n정하다","fix"));
		Data.add(new Word("좋은\n벌금\n미세한\n잘\n고급의","fine"));
		Data.add(new Word("앞\n전선\n면\n앞면\n프런트","front"));
		Data.add(new Word("수치\n인물\n생각하다\n피겨\n인형","figure"));
		Data.add(new Word("화재\n불\n발사하다\n소방의\n해고하다","fire"));
		Data.add(new Word("얼굴\n직면하다\n표정","face"));
		Data.add(new Word("강요하다\n군대\n힘\n세력\n효력","force"));
		Data.add(new Word("첫\n처음의\n최초\n먼저\n우선","first"));
		Data.add(new Word("꼭 맞는\n부합\n어울리는\n건강한\n착용","fit"));
		Data.add(new Word("빨리\n빠른\n단식하다\n단식일\n깊게","fast"));
		Data.add(new Word("가득한\n완전한\n전체\n본격적인\n많은","full"));
		Data.add(new Word("찾다\n발견하다\n알다\n알아보다","find"));
		Data.add(new Word("느끼다\n기분\n감정","feel"));
		Data.add(new Word("유동\n흐름\n몰입\n유입\n플로우","flow"));
		Data.add(new Word("…에서\n…으로부터\n…부터","from"));
		Data.add(new Word("꽃\n꽃을 피우다","flower"));
		Data.add(new Word("친구\n프랜드\n벗\n동창","friend"));
		Data.add(new Word("싸우다\n싸움\n맞서다\n전투\n이기다","fight"));
		Data.add(new Word("두려움\n공포\n우려\n걱정하다\n불안","fear"));
		Data.add(new Word("받다\n얻다\n가지다\n…시키다\n알아듣다","get"));
		Data.add(new Word("좋은\n잘\n훌륭한\n착한\n괜찮은","good"));
		Data.add(new Word("위대한\n큰\n훌륭한\n좋은\n많은","great"));
		Data.add(new Word("지상의\n땅\n기반\n영역\n기본의","ground"));
		Data.add(new Word("주다\n전하다\n제공하다\n기부하다\n수여하다","give"));
		Data.add(new Word("게임\n경기\n시합","game"));
		Data.add(new Word("유리\n안경\n잔\n컵\n렌즈","glass"));
		Data.add(new Word("그룹\n단체\n집단\n무리","group"));
		Data.add(new Word("성장하다\n자라다\n크다\n증가하다\n늘다","grow"));
		Data.add(new Word("…인 것 같다\n…라고 생각하다\n추측하다\n맞히다\n짐작하다","guess"));
		Data.add(new Word("얻다\n증가하다\n이익\n획득하다\n달성하다","gain"));
		Data.add(new Word("신\n하느님\n세상에\n우상","god"));
		Data.add(new Word("정원\n가든\n원예를 하다","garden"));
		Data.add(new Word("녹색의\n환경 친화적인\n푸른\n잔디\n야채의","green"));
		Data.add(new Word("기쁜\n좋은\n다행인\n고마운\n반가운","glad"));
		Data.add(new Word("소녀\n여자아이\n여학생\n미혼여성\n딸","girl"));
		Data.add(new Word("총\n무기\n포\n거물","gun"));
		Data.add(new Word("풀\n잔디\n목장","grass"));
		Data.add(new Word("상품\n물품\n물건\n재화\n물자","goods"));
		Data.add(new Word("모이다\n수집하다\n받다\n모임\n모여들다","gather"));
		Data.add(new Word("경비원\n보호하다\n경계\n가드\n막다","guard"));
		Data.add(new Word("가이드\n안내하다\n유도하다\n지도하다\n인도하다","guide"));
		Data.add(new Word("성장\n증가\n상승\n자람\n증대","growth"));
		Data.add(new Word("일반의\n장군\n전반적인\n장관의\n보통의","general"));
		Data.add(new Word("가지다\n얻다\n걸리다\n낳다\n소유하다","have"));
		Data.add(new Word("높은\n많은\n첨단의\n큰\n비싼","high"));
		Data.add(new Word("중(重)…\n무거운\n강력한\n과중한\n심한","heavy"));
		Data.add(new Word("열다\n보유하다\n잡다\n기다리다","hold"));
		Data.add(new Word("손\n주다\n도움\n박수\n맡기다","hand"));
		Data.add(new Word("열심히\n어려운\n힘든\n강경한\n고생","hard"));
		Data.add(new Word("집\n가정의\n홈\n고향의\n주택","home"));
		Data.add(new Word("걸다\n달다\n교수형에 처하다\n요령\n견디다","hang"));
		Data.add(new Word("더운\n뜨거운\n매운\n인기 있는\n잘하는","hot"));
		Data.add(new Word("집\n주택\n하우스\n의회\n가정의","house"));
		Data.add(new Word("치다\n히트를 치다\n타격\n달하다\n명중하다","hit"));
		Data.add(new Word("돕다\n도움\n도와주다\n기여하다","help"));
		Data.add(new Word("열\n가열하다\n난방\n뜨거워지다\n더위","heat"));
		Data.add(new Word("어떻게\n얼마나\n방법\n몇\n정말","how"));
		Data.add(new Word("문제\n쟁점\n이슈\n사안\n발행하다","issue"));
		Data.add(new Word("그것\n이것\n그런","it"));
		Data.add(new Word("아픈\n나쁜\n잘못된\n좋지 않은\n고생하다","ill"));
		Data.add(new Word("관심\n이자\n이해관계","interest"));
		Data.add(new Word("정보\n자료\n뉴스\n안내\n보도","information"));
		Data.add(new Word("생각\n아이디어\n방법\n개념\n사상","idea"));
		Data.add(new Word("이미지\n영상\n사진\n인상\n모습","image"));
		Data.add(new Word("만약\n…라면\n만일","if"));
		Data.add(new Word("들어가다\n속으로\n안으로\n빠져 있다","into"));
		Data.add(new Word("산업\n업계\n제조업\n공업","industry"));
		Data.add(new Word("소개하다\n도입하다\n선보이다\n제출하다\n발표하다","introduce"));
		Data.add(new Word("초대하다\n초청하다\n부르다\n권하다\n초래하다","invite"));
		Data.add(new Word("의도하다\n계획하다\n하려고 하는\n의미하다","intend"));
		Data.add(new Word("상상하다\n생각하다\n짐작하다","imagine"));
		Data.add(new Word("정말로\n사실은","indeed"));
		Data.add(new Word("중요한\n주요한\n중대한\n소중한","important"));
		Data.add(new Word("흥미로운\n재미있는\n놀라운","interesting"));
		Data.add(new Word("증가하다\n늘리다\n인상되다\n확대하다\n상승하다","increase"));
		Data.add(new Word("영향\n요인\n변화\n결과\n작용","influence"));
		Data.add(new Word("수입하다\n중요하다\n들여오다","import"));
		Data.add(new Word("보험\n보험금","insurance"));
		Data.add(new Word("상상\n창의성\n착각","imagination"));
		Data.add(new Word("사건\n사고\n사태\n사변","incident"));
		Data.add(new Word("개선하다\n향상하다\n증진시키다\n높아지다\n나아지다","improve"));
		Data.add(new Word("것만 \n그냥\n단지\n그저\n방금","just"));
		Data.add(new Word("직무\n일\n직업\n일자리\n수술","job"));
		Data.add(new Word("참여하다\n가입하다\n합치다\n잇다\n만나다","join"));
		Data.add(new Word("기쁨\n즐거움\n행복\n환희\n만족","joy"));
		Data.add(new Word("판사\n판단하다\n심사하다\n평가하다\n판결하다","judge"));
		Data.add(new Word("일본의\n일본인\n일본어\n일본식","japanese"));
		Data.add(new Word("농담\n장난\n놀리다\n재담","joke"));
		Data.add(new Word("정의\n사법\n공정\n재판\n판사","justice"));
		Data.add(new Word("잼\n채워넣은\n방해하다\n막히는\n즉흥적인","jam"));
		Data.add(new Word("6월","june"));
		Data.add(new Word("여행\n여정\n길\n항해\n행로","journey"));
		Data.add(new Word("공동의\n관절\n합동의\n합작의\n조인트","joint"));
		Data.add(new Word("턱\n입\n수다","jaw"));
		Data.add(new Word("병\n항아리\n단지","jar"));
		Data.add(new Word("주니어\n2학년인\n1학년인\n3학년인\n후배","junior"));
		Data.add(new Word("질투하는\n시기하는\n부러워하는\n탐내는","jealous"));
		Data.add(new Word("주스\n즙\n힘","juice"));
		Data.add(new Word("일본","japan"));
		Data.add(new Word("1월","january"));
		Data.add(new Word("보석광물\n보석\n보배","jewel"));
		Data.add(new Word("유쾌한\n즐거운\n매우\n비위를 맞추다","jolly"));
		Data.add(new Word("언론계\n저널리즘\n신문 잡지","journalism"));
		Data.add(new Word("판단\n심판\n판결\n결정\n평가","judgment"));
		Data.add(new Word("재킷\n상의\n조끼\n표지","jacket"));
		Data.add(new Word("유지하다\n계속하다\n…인 상태를 지키다\n기르다\n간직하다","keep"));
		Data.add(new Word("종류\n…가지\n친절한\n부드러운\n착한","kind"));
		Data.add(new Word("알다\n알려져 \n인식하다","know"));
		Data.add(new Word("죽이다\n살해하다\n사망하다\n목숨을 앗아가다\n자살하다","kill"));
		Data.add(new Word("부엌\n주방","kitchen"));
		Data.add(new Word("핵심\n중요한\n주요한\n열쇠\n키","key"));
		Data.add(new Word("지식\n아는 것\n인지\n학식","knowledge"));
		Data.add(new Word("키스\n입맞춤\n뽀뽀","kiss"));
		Data.add(new Word("두드리다\n노크하다\n때리기\n충돌시키다\n녹","knock"));
		Data.add(new Word("칼\n나이프\n흉기\n부엌칼\n식칼","knife"));
		Data.add(new Word("왕\n킹\n국왕\n황제\n최고","king"));
		Data.add(new Word("무릎\n슬관절","knee"));
		Data.add(new Word("아이\n어린이\n놀리다\n아들\n농담하다","kid"));
		Data.add(new Word("매듭\n노트\n난제","knot"));
		Data.add(new Word("빛\n밝게하다\n조명\n광선\n가벼운","light"));
		Data.add(new Word("…같은\n좋아하다\n…하고 싶은\n마치\n마찬가지로","like"));
		Data.add(new Word("긴\n오래\n오랫동안\n오랜\n장거리의","long"));
		Data.add(new Word("이끌다\n주도권\n앞서다\n선두\n납","lead"));
		Data.add(new Word("낮은\n저\n최저의\n적은\n떨어지는","low"));
		Data.add(new Word("낳다\n눕다\n놓다\n마련하다\n쌓다","lay"));
		Data.add(new Word("땅\n토지\n착륙하다\n지역\n국토","land"));
		Data.add(new Word("살다\n생활하다\n거주하다\n생방송의\n생존하다","live"));
		Data.add(new Word("법\n법률\n법칙\n법안\n규정","law"));
		Data.add(new Word("작은\n조금\n좀\n약간의\n어린","little"));
		Data.add(new Word("거짓말\n눕다\n놓여 있다\n속이다\n존재하다","lie"));
		Data.add(new Word("삶\n생명\n생활\n인생\n평생의","life"));
		Data.add(new Word("수준\n정도\n레벨\n…급\n높이","level"));
		Data.add(new Word("무게\n부담량\n싣다\n로딩\n짐","load"));
		Data.add(new Word("사랑하다\n좋아하다\n러브\n애정\n연애","love"));
		Data.add(new Word("떠나다\n남기다\n맡기다\n출발하다","leave"));
		Data.add(new Word("잃다\n지다\n길을 잃다\n감소하다\n상실하다","lose"));
		Data.add(new Word("편지\n글자\n문서\n…장(狀)","letter"));
		Data.add(new Word("보다\n찾다\n표정\n바라보다\n살펴보다","look"));
		Data.add(new Word("말기의\n늦은\n늦도록\n늦게\n최근의","late"));
		Data.add(new Word("웃다\n웃음\n비웃다\n재미있어하다","laugh"));
		Data.add(new Word("언어\n...어\n말\n어학\n용어","language"));
		Data.add(new Word("큰\n대규모의\n많은\n거대한\n커다란","large"));
		Data.add(new Word("…하게 해주다\n…하도록 두다\n들여보내다\n방치하다\n세놓다","let"));
		//데이터 추가 끝, 모든 단어 정보는 다음에서 가져옴, 파이썬 크롤러를 사용하여 데이터 추출 후 복사 붙여넣기
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Translator();
	}

}
