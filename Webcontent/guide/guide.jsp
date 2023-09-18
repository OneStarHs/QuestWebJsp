<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>퀘스트샵</title>
        <link rel="stylesheet" href="css/guide.css">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/footer.css">
        <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 

    </head>
    <body>
<%@ include file="../header/header.jsp" %>
<form action="guide.do" method="post" name="frm">
  <div class="color1">
           <section id="top">
       <div class="Notice">
           <h1>요금 안내</h1>
       </div>
       <div class="search-window">
       </div>
          </section>
         </div>
  
    <div class="free">  
    <section id="left_main">
    <div class="search-window">
        
    </div>
        <h3>왼쪽 내용</h3>
    <aside id="left">
        <div id="title">
            요금 안내
        </div>      
        <ul>                  
            <li><a href="graph.do">요금표</a></li>                       
        </ul>
    </aside>
    </section>

    <section id="right_main">      
    </section>

    <section id="right_main">
        <h3>오른쪽 내용</h3>
       
    <aside id="right">
        <div class="ri">
            <div class="buze3">
                <h2>대중교통 서비스</h2>
                <h4>시간에 상관없이 저렴하게 당일 배송을 받고 싶으실 때 필요한 서비스입니다.</h4>
            </div>
            <div class="r_3">
                <table class="dubuk">
                    <tr>
                        <th class="zero" colspan="3">대중교통 서비스</th>
                    </tr>
                    <tr>
                        <td colspan="3">
                        <div class="img">
                        <img src="img/걷기.jpg" style="width:80px; height:80px">
                        <img src="img/버스.jpeg" style="width:80px; height:80px">
                        <img src="img/지하철.png" style="width:80px; height:80px">
                        </div>
                        </td>
                    </tr>

                    <tbody class="ty">
                    <tr>
                        <td class="one">접수 방법</td>
                        <td class="two" colspan="2">인터넷 / 전화(1234-1234)</td>                       
                    </tr>
                    <tr>
                        <td class="one">물건 범위</td>
                        <td class="two" colspan="2">10kg 이내(박스 제외)</td>                        
                    </tr>
                    <tr>
                        <td class="one" rowspan="3">중량 가능 규격 <p>(최대 중량 10kg)</p></td>
                        <td class="two" colspan="2">소 : 3kg 이내</td>                        
                    </tr>
                    <tr>                        
                        <td class="two" colspan="2">중 : 5~6kg 이내</td>                        
                    </tr>
                    <tr>                        
                        <td class="two" colspan="2">대 : 10kg 이내</td>                        
                    </tr>
                    <tr>
                        <td class="one">주요 배송 지역</td>
                        <td class="two" colspan="2">서울, 경기 및 인접 지역</td>                        
                    </tr>
                    <tr>
                        <td class="one">배송 소요 시간</td>
                        <td class="two" colspan="2">5분 내로 사람 배정, 픽업 후 30~180분 이내(※ 거리에 따라 차이가 있음)</td>                        
                    </tr>
                    <tr>
                        <td class="one" rowspan="4">요금 구성</td>
                        <td class="three">기본 요금</td>   
                        <td class="four"> 거리별 적용 요금</td>                     
                    </tr>                   
                    <tr>                       
                        <td class="three">왕복 요금</td>                       
                        <td class="four">적용 요금의 70%(백원 단위 반올림)</td>
                    </tr>
                    <tr>
                        <td class="three">할증 요금</td>                   
                        <td class="four">영업 외 시간에는 소정의 할증료가 적용됩니다.</td>     
                    </tr>
                    <tr>
                        <td class="three">취소 요금</td>                        
                        <td class="four">5,000원, 기사가 건물에 도착한 후 취소 요청시</td>
                    </tr>
                    <tr>
                        <td class="one">접수 가능 시간</td>
                        <td class="two" colspan="2">인터넷/전화 접수 - 08:00~20:00시까지 가능합니다.</td>                        
                    </tr>
                </tbody>
                </table>
            </div>

            <div class="buze">
                <h2>오토바이 퀵서비스</h2>
                <p>오토바이 퀵서비스는 급박한 순간에 필요한 배송서비스입니다.</p>
                <p>서울 시내를 1~2시간내로 빠르게 배송하며 저렴해서 가장 보편적으로 많이 쓰이는 퀵서비스입니다.</p>
            </div>
            <div class="r_1">
                <table class="bicycle">
                    <tr>
                        <th class="zero" colspan="3">오토바이 퀵서비스</th>
                    </tr>
                    <tr>
                        <td colspan="3">
                        <div class="img">
                        <img src="img/오토바이.jpg" style="width:600px; height:180px">
                        </div>
                        </td>
                    </tr>

                    <tbody class="ty">
                    <tr>
                        <td class="one">접수 방법</td>
                        <td class="two" colspan="2">인터넷 / 전화(1234-1234)</td>                       
                    </tr>
                    <tr>
                        <td class="one">화물 범위</td>
                        <td class="two" colspan="2">중박스 2개까지 (중박스 : 세 변의 합이 100cm)</td>                        
                    </tr>
                    <tr>
                        <td class="one" rowspan="3">적재 가능 규격 <p>(최대 적재 중량 30kg)</p></td>
                        <td class="two" colspan="2">소 : A4보다 작은 물건(가로+세로+높이의 합이 70cm 이내)</td>                        
                    </tr>
                    <tr>                        
                        <td class="two" colspan="2">중 : 우체국 3호, 4호(가로+세로+높이의 합이 100cm 이내)</td>                        
                    </tr>
                    <tr>                        
                        <td class="two" colspan="2">대 : 우체국 5호, 6호(가로+세로+높이의 합이 150cm 이내)</td>                        
                    </tr>
                    <tr>
                        <td class="one">주요 배송 지역</td>
                        <td class="two" colspan="2">서울, 경기 및 인접 지역</td>                        
                    </tr>
                    <tr>
                        <td class="one">배송 소요 시간</td>
                        <td class="two" colspan="2">5~10분 내로 기사 배정, 픽업 후 30~180분 이내(※ 거리에 따라 차이가 있음)</td>                        
                    </tr>
                    <tr>
                        <td class="one" rowspan="5">요금 구성</td>
                        <td class="three">기본 요금</td>   
                        <td class="four"> 거리별 적용 요금으로 화물 기준은 중간박스 1개/20kg</td>                     
                    </tr>
                    <tr>                        
                        <td class="three">과적 요금</td>
                        <td class="four">추가 5,000원, 라면 박스(세 변의 합 : 1m)보다 클 경우</td>                     
                    </tr>
                    <tr>                       
                        <td class="three">왕복 요금</td>                       
                        <td class="four">적용 요금의 70%(백원 단위 반올림)</td>
                    </tr>
                    <tr>
                        <td class="three">할증 요금</td>                   
                        <td class="four">영업 외 시간에는 소정의 할증료가 적용됩니다.</td>     
                    </tr>
                    <tr>
                        <td class="three">취소 요금</td>                        
                        <td class="four">5,000원, 기사가 건물에 도착한 후 취소 요청시</td>
                    </tr>
                    <tr>
                        <td class="one">접수 가능 시간</td>
                        <td class="two" colspan="2">인터넷/전화 접수 - 08:00~20:00시까지 가능합니다.</td>                        
                    </tr>
                 </tbody>
                </table>
            </div>
            
            <div class="buze2">
                <h2>라보 퀵서비스</h2>
                <p>시간에 상관없이 당일 배송을 받고 싶으실 때 필요한 배송서비스입니다.</p>
            </div>
            <div class="r_2">
                <table class="labo">
                    <tr>
                        <th class="zero" colspan="3">라보 퀵서비스</th>
                    </tr>
                    <tr>
                        <td colspan="3">
                        <div class="img">
                        <img src="img/라보.png" style="width:600px; height:180px">
                        </div>
                        </td>
                    </tr>

                    <tbody class="ty">
                    <tr>
                        <td class="one">접수 방법</td>
                        <td class="two" colspan="2">인터넷 / 전화(1234-1234)</td>                       
                    </tr>
                    <tr>
                        <td class="one">화물 범위</td>
                        <td class="two" colspan="2">오토바이에 적재 못하는 큰짐 또는 무거운 짐</td>                        
                    </tr>
                    <tr>
                        <td class="one">적재 가능 규격 <p>(최대 적재 중량 450kg)</p></td>
                        <td class="two" colspan="2">450kg 미만의 중량물
                            (건축자재, 공입용기계, 신문사의 지국 배송물, 행사용 악기, 장농 진열장, 운동기구, 나무나 화환)</td>                        
                    </tr>
                                       
                    <tr>
                        <td class="one">주요 배송 지역</td>
                        <td class="two" colspan="2">서울, 경기 및 인접 지역</td>                        
                    </tr>
                    <tr>
                        <td class="one">배송 소요 시간</td>
                        <td class="two" colspan="2">30분 내로 기사 배정, 상하차 시간 및 거리별 소요시간</td>                        
                    </tr>
                    <tr>
                        <td class="one" rowspan="4">요금 구성</td>
                        <td class="three" rowspan="2">기본 요금</td>   
                        <td class="four"> 오토바이 기본요금 + 라보18,000원은 용달협정요금</td>                     
                    </tr>                    
                    <tr>                  
                        <td class="four">적용 요금의 70%(백원 단위 반올림)</td>
                    </tr>
                    <tr>
                        <td class="three">할증 요금</td>                   
                        <td class="four">영업 외 시간에는 소정의 할증료가 적용됩니다.</td>     
                    </tr>
                    <tr>
                        <td class="three">취소 요금</td>                        
                        <td class="four">5,000원, 기사가 건물에 도착한 후 취소 요청시</td>
                    </tr>
                    <tr>
                        <td class="one">접수 가능 시간</td>
                        <td class="two" colspan="2">인터넷/전화 접수 - 08:00~20:00시까지 가능합니다.</td>                        
                    </tr>
                </tbody>
                </table>
            </div>
            
    </aside>
    </section>
</div> 
</form>
<%@ include file="../footer/footer.jsp" %>

  
</body>
</html>