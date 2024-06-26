# Navigation Component
![image](https://hackmd.io/_uploads/B1s5gQ_LR.png)

## 介紹與理論
![CleanShot 2024-03-27 at 11.36.10](https://hackmd.io/_uploads/HytVEfbk0.png)

- Navigation Component 是一套用於應用程式內導航的庫、工具和指導。
- 主要原則是使用一個 Activity 和多個 Fragment。
- Navigation Component 負責處理 Fragment 之間的轉換，使開發者無需擔心。
  
## 三個重要元素
### **Navigation Graph (導航圖)**
![CleanShot 2024-03-27 at 11.38.16](https://hackmd.io/_uploads/H1PR4GZy0.png)
- 定義了應用程式中所有可能的路徑。
- 以 XML 資源檔形式存在，用於視覺化連接各個 Fragment 或 Activity。
  
### **Nav Host (導航宿主)**
![CleanShot 2024-03-27 at 11.39.20](https://hackmd.io/_uploads/B1ngSfbkC.png)

- 顯示導航圖中的目的地。
- 使用 NavHostFragment 作為預設實現。

### **Nav Controller (導航控制器)**
![CleanShot 2024-03-27 at 11.40.45](https://hackmd.io/_uploads/BynHrfb1A.png)

- 控制目的地之間的切換，隨著使用者在應用程式中移動。

## 實作示例
Old Fashioned Way（老方式）
![CleanShot 2024-03-27 at 11.49.38](https://hackmd.io/_uploads/Hk39wMZkC.png)
New Resource Directory
![CleanShot 2024-03-27 at 11.57.59](https://hackmd.io/_uploads/BkI8tGZy0.png)

使用 Resource Manager
![CleanShot 2024-03-27 at 11.54.30](https://hackmd.io/_uploads/r1PsufW1R.png)
Navigation Resourece File
![CleanShot 2024-03-27 at 11.56.31](https://hackmd.io/_uploads/BJfztfW1R.png)

- 創建 Navigation 目錄，使用 Resource Manager 中的導航選項。
- 在 Navigation Graph 中創建 Fragment 和定義其之間的動作。
    ![CleanShot 2024-03-27 at 12.02.58](https://hackmd.io/_uploads/ryhT9fbJC.png)
    Create New Destination
    ![CleanShot 2024-03-27 at 12.05.14](https://hackmd.io/_uploads/SJaNoMZ1A.png)

- 在 XML 中設置動畫以定製 Fragment 過渡效果。
- 實現點擊事件，使用 NavController 導航到不同的目的地。

## 關於導航圖
- 使用 XML 表示導航圖，其中包含 Fragment 和它們之間的動作。
- 可以為動作命名，使其更容易理解。

## 導航宿主和目的地
![CleanShot 2024-03-27 at 14.07.30](https://hackmd.io/_uploads/ryZnv4-1C.png)
![CleanShot 2024-03-27 at 14.07.42](https://hackmd.io/_uploads/r1j2DV-JR.png)
![CleanShot 2024-03-27 at 14.08.46](https://hackmd.io/_uploads/r1qlONZJR.png)
- 導航宿主包含所有目的地，用於顯示導航圖中的內容。
- 每個目的地都可以定義為起始目的地。

## 動畫效果
![image](https://hackmd.io/_uploads/BJlH2V-kR.png)
在 NavGraph 點擊導覽線（action）在 Attributes 會出現 Animations。

- 可以使用預設動畫效果或自定義動畫效果，用於 Fragment 過渡。
- 動畫效果可以在 XML 中定義，為應用程式增添視覺效果。
 
 
# Safe Args with Navigation Component
![image](https://hackmd.io/_uploads/HJb2lX_UR.png)

## Safe Args
![CleanShot 2024-06-25 at 16.19.34](https://hackmd.io/_uploads/H1mhpxu80.png)
導航元件有一個名為 Safe Args 的 Gradle 插件，它產生簡單的物件和建構器類，用於類型安全導航和存取任何關聯的參數。
強烈建議使用 Safe Args 來導航和傳遞數據，因為它可以確保類型安全。

## 新增 Arguments
![CleanShot 2024-06-25 at 17.51.03](https://hackmd.io/_uploads/SJTGmM_IR.png)

## 新增導航的 Gradle 插件
添加 navigation-safe-args-gradle-plugin 的 classpath 依賴
```
plugins {
    id 'com.android.application' version '8.0.2' apply false
    id 'com.android.library' version '8.0.2' apply false
    id 'org.jetbrains.kotlin.android' version '1.8.20' apply false
    id 'androidx.navigation.safeargs' version '2.7.7' apply false
}
```
使用 Safe Args 插件

```
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id "androidx.navigation.safeargs.kotlin"
}

```
## Rebuild 進而生成 SecondFragmentArgs
![CleanShot 2024-06-25 at 18.29.41](https://hackmd.io/_uploads/SkfLnf_8A.png)


# Navigation Drawer
![image](https://hackmd.io/_uploads/rklCgXuUC.png)

Demo
![CleanShot 2024-06-25 at 21.57.04](https://hackmd.io/_uploads/rJ0AhBuU0.gif)


## 導航抽屜介紹
![CleanShot 2024-06-25 at 19.10.30](https://hackmd.io/_uploads/BkYnHXd8C.png)

* 導航抽屜（Navigation Drawer）是一個 UI 面板（UI Panel），顯示應用程式的主導航選單（Main Navigation Menu）。
* 當使用者觸摸應用程式列中的抽屜圖示或使用者從螢幕左邊緣滑動手指時，抽屜就會出現。

## 基礎設定
- **項目準備**：使用之前影片中的專案，該專案已經實現了導航組件和 Safe Args 的基本設定。
- **佈局修改**：在 `activity_main` 的佈局文件中，將 `DrawerLayout` 設置為根元素，並在其中嵌入 `NavigationView` 來表示抽屜選單。
![CleanShot 2024-06-25 at 19.23.37](https://hackmd.io/_uploads/Hk0ad7_L0.png)

## 實作步驟
1. **初始化導航控制器**：在 `MainActivity` 中創建並初始化 `NavController` 對象。
2. **設置導航抽屜**：建立 `AppBarConfiguration` 物件，配置包含導航圖和抽屜布局的參數。
3. **連接導航視圖和導航控制器**：使用 `setupWithNavController` 方法將 `NavigationView` 設置為使用導航控制器。

## 菜單配置
- **菜單建立**：在 `menu` 資源文件夾中創建抽屜菜單，並將菜單項目與導航目的地 ID 關聯。
![CleanShot 2024-06-25 at 19.36.14](https://hackmd.io/_uploads/S1Taj7_LA.png)
新增 Menu Resource File
![CleanShot 2024-06-25 at 19.37.05](https://hackmd.io/_uploads/rJCenXu8C.png)

- **覆寫導航方法**：實現 `onSupportNavigateUp` 方法以支持導航抽屜的上行導航。

## 額外功能實現
- **動態更改動作條顏色**：使用 `NavController.OnDestinationChangedListener` 在不同導航目的地間改變動作條的背景色。
- **生命週期管理**：在 `onResume` 和 `onPause` 方法中分別添加和移除目的地變更監聽器。


# BottomNavigationView
![image](https://hackmd.io/_uploads/rJofkruUC.png)

Demo
![CleanShot 2024-06-25 at 23.22.39](https://hackmd.io/_uploads/r1pk-wOU0.gif)

## 項目設定
- **創建新項目**：開始一個新的 Android Studio 項目，刪除預設的 TextView，並新增 Bottom Navigation View。
![CleanShot 2024-06-25 at 22.01.01](https://hackmd.io/_uploads/r1xhTHOL0.png)

- **依賴管理**：當 Android Studio 提示添加依賴時，選擇確定並等待 Gradle 構建完成。

## 布局配置
- **設置 Constraint Widget**
![CleanShot 2024-06-25 at 22.02.57](https://hackmd.io/_uploads/rkImCHOI0.png)

- **底部導航設定**：對 Bottom Navigation View 設定 `match_parent` 的寬度和 `wrap_content` 的高度，背景設為白色。


## 導航組件設定
- **導航圖（Navigation Graph）**：在 Resource Manager 中添加導航圖，命名為 "my_nav"，並將所有相關依賴添加完畢後，開始添加目的地，創建三個 Fragment：First Fragment、Second Fragment 和 Third Fragment，這三個都設為頂級目的地（Top Destinations）。
![CleanShot 2024-06-25 at 22.05.30](https://hackmd.io/_uploads/HkuykUuUR.png)

- 新增 NavHostFragment
![CleanShot 2024-06-25 at 22.12.16](https://hackmd.io/_uploads/H1-Ig8dIA.png)
- 設定 Constraint Widget
![CleanShot 2024-06-25 at 22.13.46](https://hackmd.io/_uploads/BJvplL_UA.png)


## 布局設計
- **自定義 Fragment 佈局**：每個 Fragment 佈局中中央加入一個 TextView，顯示對應的 Fragment 名稱，並設置文字大小。

## 菜單與導航連接
- **創建底部菜單**：在 menu 資源文件夾中創建名為 "bottom_menu" 的菜單資源文件，加入三個項目並分別關聯到三個 Fragment 的 ID。
![CleanShot 2024-06-25 at 22.29.12](https://hackmd.io/_uploads/B11LVIdLC.png)
- 新增 Menu Item
![CleanShot 2024-06-25 at 22.30.19](https://hackmd.io/_uploads/B1k5NIdU0.png)

- **圖標與標題設置**：為每個菜單項目設置對應的向量圖標和標題（如 Home、Profile 和 Settings）。

## 實際應用與調試
- **初始化並設置底部導航與導航控制器**：在 MainActivity 中初始化 Bottom Navigation View 和 NavController，並使用 `setupWithNavController` 方法將兩者關聯。
- **動態改變動作欄標題**：創建 AppBarConfiguration 對象，將三個頂級目的地添加到集合中，並使用 `setupActionBarWithNavController` 方法來更新動作欄標題。

## 編譯設置
- **更新編譯選項**：若有必要，更新 Gradle 檔案中的編譯選項，將 Java 版本設定為 1.8。

## 執行與效果展示
- **應用運行**：運行應用後可以看到底部導航欄成功切換不同 Fragment，並能正確顯示對應的標題。

# ViewPager2 - Onboarding Screens
![image](https://hackmd.io/_uploads/H16WZwd80.png)

## 創建SplashFragment

- 新建一個名為SplashFragment的Fragment。
- 在SplashFragment的layout中，只保留OnCreateView方法，並設置背景。

## 創建Navigation Graph

- 新建一個名為my_nav的navigation graph。
- 將SplashFragment設置為start destination。

## 添加NavHostFragment

- 在MainActivity中添加NavHostFragment。
- 將NavHostFragment設置為start destination。

## 隱藏Action Bar

- 在MainActivity中使用supportActionBar.hide()方法隱藏Action Bar。

## 創建Onboarding畫面

- 創建一個名為onboarding的package。
- 在onboarding package中創建一個名為ViewPagerFragment的Fragment。

## 設置ViewPagerFragment

- 在ViewPagerFragment的layout中使用ConstraintLayout。
- 添加ViewPager並設置約束。
![CleanShot 2024-06-26 at 10.32.37](https://hackmd.io/_uploads/B1sl0gFIR.png)

- 創建ViewPagerAdapter來管理Fragment。

## 創建Onboarding屏幕

- 在onboarding package中創建三個Fragment，分別代表三個Onboarding屏幕。
- 設置每個Onboarding屏幕的layout，包含ImageView、Title、Description和Next按鈕。

## 設置ViewPagerAdapter

- 在ViewPagerFragment中創建一個包含三個Onboarding屏幕的Fragment列表。
- 初始化ViewPagerAdapter並設置給ViewPager。

## 添加導航邏輯

- 在SplashFragment中使用Handler.postDelayed()方法，在3秒後導航到ViewPagerFragment。
- 在第三個Onboarding屏幕中設置Finish按鈕，導航到HomeFragment。

## 使用SharedPreferences儲存狀態

- 創建一個方法，使用SharedPreferences儲存Onboarding完成狀態。
- 在SplashFragment中檢查Onboarding狀態，如果已完成，則導航到HomeFragment。

## 優化導航邏輯

- 在Navigation Graph中設置導航動作，並在導航時清除返回棧中的Fragment。
- 在 Action 新增 Pop Behavior
在 `action_splashFragment_to_viewPagerFragment`
![CleanShot 2024-06-26 at 11.48.13](https://hackmd.io/_uploads/BkZj1zYIA.png)
在 `action_viewPagerFragment_to_homeFragment`
![CleanShot 2024-06-26 at 11.50.17](https://hackmd.io/_uploads/S1ezxMKLA.png)


- 測試應用確保導航邏輯正常運行，包括首次運行顯示Onboarding畫面，完成後導航到HomeFragment，以及返回鍵行為。

## 完整代碼運行測試

- 多次測試應用，包括首次運行和重複運行，確保所有邏輯正常運行。
# Custom Transition Animations
![image](https://hackmd.io/_uploads/r1KC94K8A.png) 

## 項目概述

- 設計了一個簡單的項目，包含三個主要Fragment：HomeFragment、FirstFragment和SecondFragment。
- MainActivity包含NavHostFragment，HomeFragment作為起始目的地。
- HomeFragment有兩個按鈕，分別導航到FirstFragment和SecondFragment。
- FirstFragment和SecondFragment各有一個返回按鈕，導航回HomeFragment。

## 添加動畫資源文件

- 創建四個動畫資源文件：from_left、to_right、to_left、from_right。
- 使用translate元素設置動畫。

### from_left動畫

- 根元素設置為set。
- 使用translate元素設置動畫屬性：
  - fromXDelta設置為-100%。
  - toXDelta設置為0%。
  - duration設置為300毫秒。
![CleanShot 2024-06-26 at 15.07.41](https://hackmd.io/_uploads/HkqwCVtIA.png)
![CleanShot 2024-06-26 at 15.11.19](https://hackmd.io/_uploads/r1_mkrt8R.png)

### to_right動畫

- 創建一個新的動畫資源文件，命名為to_right。
- 使用translate元素設置動畫屬性：
  - fromXDelta設置為0%。
  - toXDelta設置為100%。
  - duration設置為300毫秒。

### to_left動畫

- 創建一個新的動畫資源文件，命名為to_left。
- 使用translate元素設置動畫屬性：
  - fromXDelta設置為0%。
  - toXDelta設置為-100%。
  - duration設置為300毫秒。

### from_right動畫

- 創建一個新的動畫資源文件，命名為from_right。
- 使用translate元素設置動畫屬性：
  - fromXDelta設置為100%。
  - toXDelta設置為0%。
  - duration設置為300毫秒。

## 設置導航過渡動畫

- 打開導航圖並選擇HomeFragment到FirstFragment的箭頭。
- 在右側的動畫設置中，指定enter動畫為from_left。

### 設置其他動畫

- 對HomeFragment到FirstFragment的導航設置exit動畫為to_right。
- 對FirstFragment到HomeFragment的導航設置enter動畫為from_right，exit動畫為to_left。
- 對HomeFragment到SecondFragment的導航設置enter動畫為from_right，exit動畫為to_left。
- 對SecondFragment到HomeFragment的導航設置enter動畫為from_left，exit動畫為to_right。

## 測試動畫效果

- 測試應用，檢查過渡動畫是否正確運行。
- 確保所有導航行為都有過渡動畫，包括返回按鈕的行為。

## 圖解過渡動畫

- 使用圖形說明動畫的運行方式：
  - X軸和Y軸分別代表水平和垂直方向。
  - -100%表示在屏幕外部的左側，100%表示在屏幕外部的右側。


# Safe Args - Send Custom Object
![image](https://hackmd.io/_uploads/rkISgHKLC.png)

## 新增 Data Class
```
data class User(
    val firstName: String,
    val lastName: String
)
```

## 新增 Argument
![CleanShot 2024-06-26 at 15.34.30](https://hackmd.io/_uploads/rJJ2VHF8C.png)
## 選擇 Type
![CleanShot 2024-06-26 at 15.35.20](https://hackmd.io/_uploads/ryD1HrtUA.png)

## 擴展的 @Parcelize 註解
* 擴展的 @Parcelize 註解來實現 Parcelable 接口的資料類成 "可序列化的資料類"（Parcelable Data Class）。
* 這樣的類可以在 Android 中輕鬆地進行跨活動或片段的數據傳輸。
* 使用 @Parcelize 註解和 Parcelable 接口，使得 User 類可以被序列化和反序列化，以便在 Android 應用中進行數據傳輸。
```
@Parcelize
 data class User(
    val firstName: String,
    val lastName: String
) : Parcelable
```

## Select Class
![CleanShot 2024-06-26 at 15.47.20](https://hackmd.io/_uploads/rkW2wrYUA.png)

## Add Argument
![CleanShot 2024-06-26 at 15.48.13](https://hackmd.io/_uploads/S1N0wHF8A.png)

## Rebuild
![CleanShot 2024-06-26 at 15.56.41](https://hackmd.io/_uploads/HJwCFStUR.png)

## 傳遞資料
```
val firstName = "RainBowT"
val lastName = "ㄚT"
val user = User(firstName, lastName)

val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment(user)

findNavController().navigate(action)
```
## 接收資料
```
private val args by navArgs<HomeFragmentArgs>()

args.currentUser?.let {
    val tvFirstName = view.findViewById<TextView>(R.id.tvFirstName)
    val tvLastName = view.findViewById<TextView>(R.id.tvLastName)

    tvFirstName.text = it.firstName
    tvLastName.text = it.lastName
}
```

# Modal Bottom Sheet
![image](https://hackmd.io/_uploads/ByJMbLFU0.png)


# 關鍵字
- **Navigation Component**: 用於應用程式內導航的庫、工具和指導。
- **Fragment**: Android 應用程式開發中，用於構建和管理使用者界面的一部分。
- **Nav Host Fragment**: 實現了 NavHost 的 Fragment，用於顯示導航圖中的目的地。
- **Nav Controller**: 控制導航宿主中的目的地切換。
- **Navigation Graph**: 定義了應用程式中所有可能的路徑，以 XML 資源檔形式存在。
- **目的地 (Destination)**: 導航圖中的一個終點，可以是 Fragment 或 Activity。
- **動作 (Action)**: 定義了目的地之間的導航路徑，可以包括顯示、隱藏、傳遞參數等操作。
- **導航宿主 (Nav Host)**: 用於顯示導航圖中目的地的容器，通常是 NavHostFragment。
- **動畫效果 (Animation)**: 用於製造介面元素過渡效果的視覺特效，例如淡入淡出、滑入滑出等。
* 導航組件（Navigation Component）：一套用於應用內導航的庫、工具和指導原則，主要原則是使用一個活動（Activity）和多個片段（Fragment）進行導航。它簡化了片段事務的處理，使開發人員無需再擔心片段的交換。
* 導航圖（Navigation Graph）：一種新的 XML 資源類型，定義了應用程序中用戶可以通過的所有可能路徑。它以視覺方式顯示了從給定目的地可以到達的所有目的地，是一個 XML 資源文件，將所有片段或活動之間的關係連接在一起。
* Nav Host Fragment：導航組件的一部分，是一個空容器，用於顯示導航圖中的目的地。它包含了默認的導航實現，即 NavHostFragment，用於顯示片段目的地。
* 導航控制器（NavController）：負責控制導航主機中目的地內容的切換，隨著用戶在應用程序中移動，導航控制器管理目的地的堆棧。
* 開始目的地（Start Destination）：導航圖中標記為開始的目的地，應用程序啟動時將顯示該目的地。
* 操作（Action）：導航圖中的連接目的地之間的操作，描述了用戶從一個目的地到另一個目的地的過渡。
* 片段事務（Fragment Transactions）：在 Android 中，用於管理片段的添加、替換或移除等操作。
* 入場動畫（Enter Animation）和退場動畫（Exit Animation）：用於定義片段過渡時的動畫效果，可以通過導航圖設置。
* XML（Extensible Markup Language）：一種標記語言，用於定義結構化的數據，如 Android 配置文件和資源文件。在導航組件中，導航圖就是一個 XML 資源文件，用於定義應用程序的導航結構。
* 資源管理器（Resource Manager）：在 Android Studio 中的工具，用於管理應用程序的資源文件，包括導航圖文件的創建和編輯。 
* 片段（Fragment）：Android 應用中的一部分 UI 或行為，通常用於實現可重用的 UI 組件。
* 資源文件（Resource Files）：包括布局文件、字符串資源、圖像和其他靜態資源，用於定義應用程序的外觀和行為。
* Gradle：Android 構建系統的一部分，用於管理應用程序的依賴關係和構建配置。
* 默認動畫（Default Animations）：導航組件提供的預設動畫效果，可用於片段之間的過渡。
* 自定義動畫（Custom Animations）：開發人員定義的自定義動畫效果，用於製作個性化的片段過渡效果。
* OnClickListener：用於處理點擊事件的介面，通常用於 UI 元素，如按鈕或文本視圖。
* 轉換（Transition）：在導航過程中從一個片段到另一個片段的過渡效果。
* 堆棧（Stack）：在導航過程中用於管理目的地的一種數據結構，通常是先進後出的形式。
* XML 屬性（XML Attributes）：用於定義 XML 元素屬性的標記，如導航圖中的目的地屬性。
* 導航架構（Navigation Architecture）：應用程序中導航結構的設計和實現方式，包括目的地之間的連接和過渡效果。 
- **Navigation Drawer**: 一種用於顯示應用導航菜單的UI面板，當用戶點擊應用欄中的抽屜圖標或從屏幕左邊緣滑動時出現。
- **Navigation Component**: Android Jetpack中的一部分，用於實現應用內的導航邏輯，簡化導航和數據傳遞。
- **DrawerLayout**: Android中的一種布局，允許在主內容區域上方顯示可滑動的導航抽屜。
- **NavigationView**: 一種特殊的View，用於在DrawerLayout中顯示導航菜單。
- **NavController**: 負責在導航圖之間移動的控制器。
- **AppBarConfiguration**: 用於配置應用欄與NavController之間的協作，支持DrawerLayout。
- **OnCreate()**: Android中Activity的生命周期方法之一，在Activity創建時調用。
- **FindViewById()**: 用於在佈局中找到指定ID的View。
- **Menu Resource File**: 用於定義應用菜單項的XML文件。
- **OnSupportNavigateUp()**: 在應用欄的向上導航按鈕被按下時調用的方法。
- **NavController.OnDestinationChangedListener**: 用於監聽導航目的地變更的監聽器。
- **SetUpActionBarWithNavController()**: 將應用欄與NavController設置聯動的方法。
- **AddOnDestinationChangedListener()**: 向NavController添加目的地變更監聽器的方法。
- **RemoveOnDestinationChangedListener()**: 從NavController移除目的地變更監聽器的方法。
- **ViewPager**: 一種允許用戶在頁面之間滑動的視圖，用於在應用中創建分頁導航。
- **Navigation Component**: Android Jetpack中的一部分，用於實現應用內的導航邏輯，簡化導航和數據傳遞。
- **Onboarding Screens**: 在應用首次啟動時顯示的引導頁面，用於介紹應用功能和操作方法。
- **Fragment**: 一個可重用的UI組件，表示應用界面的一部分。
- **Navigation Graph**: 定義應用中各個導航目的地和行動的XML文件。
- **NavHostFragment**: 負責在應用中顯示導航圖中指定目的地的容器。
- **FragmentStateAdapter**: 一種適配器，用於管理Fragment的狀態，適用於ViewPager2。
- **Lifecycle**: 表示Android應用程序組件（如Activity或Fragment）生命週期的對象。
- **Shared Preferences**: 用於保存和檢索應用中輕量級數據的持久化存儲方式。
- **Handler**: 用於在一段時間後執行代碼或在主線程上調度操作的工具。
- **OnCreate()**: Android中Activity或Fragment的生命周期方法之一，在創建時調用。
- **FindViewById()**: 用於在佈局中找到指定ID的View。
- **SetOnClickListener()**: 用於設置點擊事件監聽器的方法。
- **PostDelayed()**: 用於在指定延遲後執行Runnable對象的方法。
- **NavController**: 負責在導航圖之間移動的控制器。
- **GetBoolean()**: 用於從Shared Preferences中檢索布爾值的方法。
- **PutBoolean()**: 用於將布爾值存儲到Shared Preferences中的方法。
- **GetItemCount()**: 返回適配器中項目數量的方法。
- **CreateFragment()**: 返回指定位置的Fragment的方法。 
- **Custom Transition Animations**: 自定義過渡動畫，用於在導航組件中實現自定義的頁面切換效果。
- **Navigation Component**: Android Jetpack中的一部分，用於實現應用內的導航邏輯，簡化導航和數據傳遞。
- **Fragment**: 一個可重用的UI組件，表示應用界面的一部分。
- **NavHostFragment**: 負責在應用中顯示導航圖中指定目的地的容器。
- **Translate Animation**: 一種動畫效果，用於將視圖從一個位置移動到另一個位置，可以設置從X到X、從Y到Y的Delta值來控制移動方向和距離。
- **Delta**: 用於動畫的百分比值，表示視圖的移動位置，例如從-100%移動到0%表示從屏幕外部移動到屏幕內部。
- **Enter Animation**: 當新Fragment進入屏幕時應用的動畫效果。
- **Exit Animation**: 當當前Fragment退出屏幕時應用的動畫效果。
- **Pop Enter Animation**: 當返回到之前的Fragment時應用的動畫效果。
- **Pop Exit Animation**: 當當前Fragment退出返回到之前的Fragment時應用的動畫效果。
- **SetUpActionBarWithNavController()**: 將應用欄與NavController設置聯動的方法。
- **OnSupportNavigateUp()**: 在應用欄的向上導航按鈕被按下時調用的方法。
- **Resource Manager**: Android Studio中的資源管理器，用於管理應用中的資源文件，如動畫、佈局等。
- **Animation Resource File**: 定義動畫效果的XML文件，使用`<set>`、`<translate>`等元素來描述動畫。
