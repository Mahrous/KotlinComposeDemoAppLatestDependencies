# Android Clean Architecture Demo

A demo Android application built with **Kotlin and Jetpack Compose**, demonstrating a modular, maintainable, and reusable architecture based on Clean Architecture principles.

The project focuses on code organization, reusable UI components, input validation, network integration, and handling different application states.

## ✨ Key Features

- **Clean Architecture:** Separation of concerns between presentation, domain, and data layers to improve maintainability and testability.
- **Multi-Module Architecture:** Modular project structure designed to improve code organization, separation of responsibilities, and reusability.
- **Input Validation:** Reusable validation methods for common signup fields and essential user inputs.
- **Reusable Compose Components:** Custom buttons and text fields designed to support different data types and configurable behavior through simple, consistent keys and parameters.
- **Status Screens:** Dedicated UI states for different data-loading scenarios, including:
  - Success
  - Empty Data
  - Network Error
- **Navigation:** Navigation graph for managing screen transitions and application navigation.
- **Dependency Injection:** Hilt for dependency management and decoupling application components.
- **REST API Integration:** Retrofit for communicating with remote APIs.
- **Kotlin Coroutines:** Asynchronous operations and non-blocking tasks.
- **Kotlin Serialization:** Serialization and deserialization of structured data.
- **Jetpack Compose:** Declarative UI development using reusable composable functions.
- **AndroidX Lifecycle:** Lifecycle-aware components and ViewModel integration.
- **DataStore Preferences:** Modern storage for application preferences.
- **Paging:** Support for paginated data loading.
- **Coil:** Image loading for Android UI.
- **Firebase:** Integration libraries for Firebase services,
-------------------------------------------------------------------------------------------------------------------------------------------------------

# مشروع Android Demo باستخدام Clean Architecture

تطبيق تجريبي مبني باستخدام **Kotlin وJetpack Compose**، يهدف إلى تطبيق مبادئ Clean Architecture وتوضيح كيفية بناء مشروع Android منظم، قابل للصيانة، وقابل لإعادة الاستخدام.

يركز المشروع على تنظيم الكود، وإنشاء مكونات UI مشتركة، والتحقق من صحة المدخلات، والتعامل مع طلبات الشبكة وحالات عرض البيانات المختلفة.

## ✨ المميزات الأساسية

- **Clean Architecture:** فصل المسؤوليات بين طبقات العرض (Presentation) والمنطق (Domain) والبيانات (Data) لتحسين قابلية الصيانة والاختبار.
- **Multi-Module Architecture:** تقسيم المشروع إلى Modules مستقلة نسبيًا لتحسين تنظيم الكود وفصل المسؤوليات وإعادة الاستخدام.
- **Input Validation:** توفير Methods قابلة لإعادة الاستخدام للتحقق من صحة خانات الإدخال الأساسية، مثل حقول التسجيل (Signup).
- **Reusable Compose Components:** مكونات UI مشتركة، مثل Buttons وText Fields، قابلة للتخصيص وتدعم أنواعًا مختلفة من البيانات من خلال Keys وParameters بسيطة وموحدة.
- **Status Screens:** شاشات وحالات مخصصة للتعامل مع مختلف نتائج تحميل البيانات، ومنها:
  - نجاح العملية (Success).
  - عدم وجود بيانات (Empty Data).
  - خطأ في الاتصال بالشبكة (Network Error).
- **Navigation Graph:** تنظيم التنقل بين شاشات التطبيق.
- **Dependency Injection:** استخدام Hilt لإدارة الاعتماديات وتقليل الترابط بين مكونات التطبيق.
- **REST API Integration:** استخدام Retrofit للتعامل مع APIs خارجية.
- **Kotlin Coroutines:** تنفيذ العمليات غير المتزامنة دون تعطيل واجهة المستخدم.
- **Kotlin Serialization:** تحويل البيانات المنظمة من وإلى صيغ قابلة للنقل والتخزين.
- **Jetpack Compose:** بناء واجهات المستخدم باستخدام Declarative UI ومكونات قابلة لإعادة الاستخدام.
- **AndroidX Lifecycle:** التعامل مع دورة حياة التطبيق ودمج ViewModel.
- **DataStore Preferences:** تخزين تفضيلات وإعدادات التطبيق.
- **Paging:** دعم تحميل البيانات على صفحات.
- **Coil:** تحميل الصور وعرضها داخل واجهات التطبيق.
- **Firebase:** مكتبات للتكامل مع خدمات Firebase، بما في ذلك Cloud Messaging وCloud Firestore.
- **Google Play Services:** مكتبات خاصة بالمصادقة والخرائط والموقع الجغرافي.
- **WorkManager:** جدولة المهام التي يمكن تنفيذها في الخلفية.
- **AndroidX Core Libraries:** استخدام مكتبات AndroidX المساعدة لتبسيط عمليات التطوير.

## 🛠️ التقنيات والمكتبات المستخدمة

| التصنيف | التقنيات |
|---|---|
| لغة البرمجة | Kotlin |
| واجهات المستخدم | Jetpack Compose |
| المعمارية | Clean Architecture, Multi-Module |
| Dependency Injection | Hilt |
| التنقل | Navigation Graph |
| Networking | Retrofit, OkHttp |
| العمليات غير المتزامنة | Kotlin Coroutines |
| Serialization | Kotlin Serialization, Gson, Moshi |
| تخزين التفضيلات | DataStore Preferences |
| تحميل الصور | Coil |
| Pagination | AndroidX Paging |
| مهام الخلفية | WorkManager |
| خدمات Backend | Firebase Cloud Messaging, Cloud Firestore |
| الخرائط والموقع | Google Maps, Maps Compose, Places SDK, Location Services |
| أدوات البناء | Gradle, Version Catalog, KSP, Android Gradle Plugin |

## 🎯 أهداف المشروع

يهدف المشروع إلى تقديم مثال عملي على:

- تطبيق مبادئ Clean Architecture في تطوير Android.
- بناء مكونات Jetpack Compose مرنة وقابلة لإعادة الاستخدام.
- توحيد أسلوب التحقق من صحة المدخلات والتعامل مع حالات الواجهة.
- تنظيم مشاريع Android باستخدام Multi-Module Architecture.
- دمج الشبكات وDependency Injection والعمليات غير المتزامنة.
- تحسين قابلية قراءة الكود وصيانته والتوسع فيه مستقبلًا.

## 📌 ملاحظة

هذا مشروع تجريبي مخصص للتعلم واستعراض ممارسات تطوير Android. يعتمد وجود كل تكامل أو ميزة على تنفيذها الفعلي داخل المشروع.
